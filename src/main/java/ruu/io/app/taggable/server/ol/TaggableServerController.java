package ruu.io.app.taggable.server.ol;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

/**
 * Definition of a scope is mandatory, otherwise endpoints will not be available and invocations will result in file not
 * found exceptions. Moreover, if CDI is used {@link ApplicationScoped} (instead of {@link RequestScoped}) seems to be
 * mandatory.
 * <p>
 * Definition of a path also seems to be mandatory, at least for open liberty
 */
@Path("/")
@ApplicationScoped
public class TaggableServerController
{
	@Inject private TaggableServerService service;

	@GET
	@Path("/system/properties")
	@Produces(APPLICATION_JSON)
	public Response getSystemProperties()
	{
		return Response.ok(service.getSystemProperties()).build();
	}

	@POST
	@Path("/event/create")
	@Produces(APPLICATION_JSON)
	@Transactional
	public Response createEventAndGetList()
	{
		return Response.ok(service.createEventAndGetList()).build();
	}
}