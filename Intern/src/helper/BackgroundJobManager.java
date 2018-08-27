package helper;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import controller.MarketDataThread;

@WebListener
public class BackgroundJobManager implements ServletContextListener {
	
	private ScheduledExecutorService scheduler;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		scheduler.shutdownNow();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		scheduler = Executors.newSingleThreadScheduledExecutor();
		scheduler.scheduleAtFixedRate(new MarketDataThread() , 0, 1, TimeUnit.MINUTES);
	}

}
