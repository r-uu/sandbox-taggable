package ruu.io.app.taggable.server.ol;

import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

import jakarta.inject.Inject;

public class TaggableServerService
{
	@Inject private EventDAO eventDAO;

	public Properties getSystemProperties()
	{
		return System.getProperties();
	}

	public List<Event> createEventAndGetList()
	{
		eventDAO.createEvent(new Event("name", "location", LocalDate.now().toString()));
		return eventDAO.readAllEvents();
	}
}