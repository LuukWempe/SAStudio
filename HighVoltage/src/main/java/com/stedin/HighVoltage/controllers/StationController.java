package com.stedin.HighVoltage.controllers;

import com.stedin.HighVoltage.model.IED;
import com.stedin.HighVoltage.model.Station;
import com.stedin.HighVoltage.repositories.IEDRepository;
import com.stedin.HighVoltage.repositories.StationRepository;
import com.stedin.HighVoltage.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StationController {
	
	@Autowired
	StationService stationService;
	
	@Autowired
	IEDService iedService;
	
	@Autowired
	StationRepository stationRepository;
	
	@Autowired
	public StationController(){}
	
	 @GetMapping("/stations")
	    public String stations(Model model) {
		 model.addAttribute("stations", stationService.getTopStations(100));
	    	return "/stations";
	    }
	 
	 @GetMapping(path="/station/view/{stationName}")
	 public String viewStation(Model model, @PathVariable("stationName") String stationName) {
		 Station station = stationRepository.findByStationName(stationName);
		 model.addAttribute("station",station);
		 model.addAttribute("ieds", stationService.getStationIed(100,station));
		 return "/station/view";
	 }
	 
	 @GetMapping(path="/station/ied/{iedID}")
	 public String viewIED(Model model, @PathVariable("iedId") Long iedId) {
		 IED ied = stationService.getStationIedByIedId(iedId);
		 Station station = stationService.getStationByIedId(iedId);
		 model.addAttribute("station", station);
		 model.addAttribute("ied",ied);
		 model.addAttribute("signals", iedService.getSignalsByIedId(100,iedId));
		 //model.addAttribute("signals", signals);
		 return "/station/ied";
	 }
	 
	 @PostMapping("/station/view")
	 public String updateStation(@RequestParam(value="action", required=false) String action) {
		 String[] actions = action.split(":");
		 switch (actions[0]) {
		 	case "view_station":
		 		return "redirect:/station/view/" + actions[1];
		 	
		 	case "view_stations":
		 		return "redirect:/stations";
		 		
		 	case "view_ied":
		 		return "redirect:/station/ied/" + actions[1];
		 		
		 	case "new_station":
		 		return "redirect:/station/newstation";
		 } 
		 return "/stations";
	 }
	 
	 @GetMapping("/station/newstation")
	 public String newStation(Model model) {
		 Station newstation = new Station();
		 model.addAttribute("newstation", newstation);
		 return "/newstation";
	 }
}