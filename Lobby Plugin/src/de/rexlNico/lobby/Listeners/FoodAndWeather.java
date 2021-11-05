package de.rexlNico.lobby.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class FoodAndWeather implements Listener{

	@EventHandler
	public void on(FoodLevelChangeEvent e){
		e.setCancelled(true);
	}
	@EventHandler
	public void on(WeatherChangeEvent e){
		e.setCancelled(true);
	}
}
