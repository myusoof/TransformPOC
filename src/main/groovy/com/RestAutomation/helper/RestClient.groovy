
import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.MappingJsonFactory
import groovyx.net.http.ContentType
import groovyx.net.http.HttpResponseDecorator
import groovyx.net.http.ParserRegistry
import groovyx.net.http.RESTClient
import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.RedirectHandler

import javax.ws.rs.core.MediaType


/**
 * Created by mohmedyusoof.as on 5/26/2016.
 */
public class RestClient extends  RESTClient {
    protected JsonFactory jsonFactory = new MappingJsonFactory()
    private RedirectHandler standardRedirectHandler

    static RestClient restClient = null;

    public static RestClient getRestInstance(){
        if(restClient == null){
            return new RestClient(ConfigurationHelper.getProperties().get("baseUrl"))
        }
        return restClient
    }

    RestClient(Object defaultURI) {
        super(defaultURI)
        encoder.charset = "UTF-8"

        parser[ContentType.JSON] = { HttpResponse resp ->
            JsonParser parser = jsonFactory.createParser(resp.entity.content)
            parser.readValueAs(Object.class)
        }

        parser["text/csv"] = { HttpResponse resp ->
            // IOUtils.readLines(resp.entity.content, "utf-8").join("\n")
        }

        handler.failure = { resp ->
            HttpEntity entity = resp.getEntity();
            if (entity == null || entity.getContentLength() == 0) {
                return resp
            }
            resp.setData(parseResponse(resp, ParserRegistry.getContentType(resp)))
            resp
        }

        standardRedirectHandler = client.redirectHandler
    }


    public Object get(Map args, String contentType = MediaType.APPLICATION_JSON) {
        this.headers['Accept'] = contentType
        HttpResponseDecorator response = (HttpResponseDecorator) super.get(args)
        this.headers['Accept'] = "*/*"
        response
    }

    @Override
    Object post(Map<String, ?> args) {
        args << [requestContentType: ContentType.JSON]
        HttpResponseDecorator response = (HttpResponseDecorator) super.post(args)
        response
    }

    @Override
    Object put(Map<String, ?> args) {
        args << [requestContentType: ContentType.JSON]
        HttpResponseDecorator response = (HttpResponseDecorator) super.put(args)
        response
    }

    @Override
    Object delete(Map<String, ?> args) {
        HttpResponseDecorator response = (HttpResponseDecorator) super.delete(args)
        response
    }

    void turnOffFollowRedirects() {
        client.redirectHandler = [isRedirectRequested: { Object[] args -> false }] as RedirectHandler
    }

    void turnOnFollowRedirects() {
        client.redirectHandler = standardRedirectHandler

    }
}