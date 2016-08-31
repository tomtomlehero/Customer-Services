package fr.mla.framework.ws.utils;



import java.util.Arrays;
import fr.mla.framework.ws.error.ErrorEO;
import fr.mla.framework.ws.error.ErrorWrapper;
import fr.mla.framework.ws.validation.exception.ValidationException;

import javax.ws.rs.core.Response;

public class ResponseUtil {

    /**
     *
     * @param responseData: the object to be sent through the Response
     * @return a Response instance with the given object as payload along with HTTP status 200 OK
     */
    public static Response okResponse(Object responseData) {
        return Response.ok(responseData).build();
    }


    /**
     *
     * @param headerStatus: The HTTP status + message to send in the header response
     *                    e.g.: Response.Status.NOT_FOUND = 404 + "Not Found"
     * @param errorId: the errorId for the ErrorEO response to send
     * @param errorDescription: the errorDescription for the ErrorEO response to send
     * @param errorMessages: any additional messages for the ErrorEO response to send
     * @return a Response instance with the an errorEO (built with
     * the given data) as payload along with given HTTP status in the header
     */
    public static Response errorResponse(
            Response.Status headerStatus,
            String errorId,
            String errorDescription,
            String... errorMessages) {

        ErrorEO errorEO = new ErrorEO();
        errorEO.setId(errorId);
        errorEO.setDescription(errorDescription);
        errorEO.getMessages().addAll(Arrays.asList(errorMessages));

        ErrorWrapper errorWrapper = new ErrorWrapper();
        errorWrapper.setError(errorEO);


        return Response.status(headerStatus).entity(errorWrapper).build();
    }


    public static Response errorResponse(ValidationException validationException) {

        ErrorEO errorEO = new ErrorEO();
        errorEO.setId("invalid_input_parameter");
        errorEO.setDescription("At least one parameter has invalid value");
        errorEO.getMessages().addAll(validationException.getErrorMessages());

        ErrorWrapper errorWrapper = new ErrorWrapper();
        errorWrapper.setError(errorEO);

        return Response.status(Response.Status.BAD_REQUEST).entity(errorWrapper).build();
    }


}
