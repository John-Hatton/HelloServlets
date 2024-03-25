import mars.hatton.servlet.HelloServlet;
import org.junit.jupiter.api.Test;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import java.io.PrintWriter;
import java.io.StringWriter;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HelloServletTest {

    @Test
    void testDoGet() throws Exception {
        // Create mock objects for HttpServletRequest, HttpServletResponse, ServletConfig, and ServletContext
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        ServletConfig config = mock(ServletConfig.class);
        ServletContext context = mock(ServletContext.class);

        // Create a StringWriter to capture the servlet response
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        // Mock the PrintWriter returned by response.getWriter()
        when(response.getWriter()).thenReturn(writer);

        // Mock the necessary methods of ServletConfig and ServletContext
        when(config.getServletContext()).thenReturn(context);
        when(context.getInitParameter("parameterName")).thenReturn("parameterValue");

        // Mock the HTTP method in the HttpServletRequest
        when(request.getMethod()).thenReturn("GET");

        // Create an instance of HelloServlet
        HelloServlet helloServlet = new HelloServlet();

        // Initialize the servlet with the mock ServletConfig
        helloServlet.init(config);

        // Invoke the servlet's service method passing the mock request and response
        helloServlet.service(request, response);

        // Flush the writer to ensure content is written to the StringWriter
        writer.flush();

        // Verify that the servlet response contains all three lines of the HTML code
        String servletResponse = stringWriter.toString().trim();
        assertTrue(servletResponse.contains("<html><head><title>Hello Servlet</title></head><body>"));
        assertTrue(servletResponse.contains("<h1>Hello, World!</h1>"));
        assertTrue(servletResponse.contains("</body></html>"));
    }
}