package de.shop.artikelverwaltung.rest;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import static javax.ws.rs.core.Response.Status.CONFLICT;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import de.shop.artikelverwaltung.service.AbstractArtikelServiceException;
import de.shop.util.Log;

 

@Provider
@ApplicationScoped
@Log
public class ArtikelResourceExceptionMapper implements ExceptionMapper<AbstractArtikelServiceException> {
	@Override
	public Response toResponse(AbstractArtikelServiceException e) {
		final String msg = e.getMessage();
		final Response response = Response.status(CONFLICT)
										  .type(TEXT_PLAIN)
										  .entity(msg)
										  .build();
		return response;
	}
}
