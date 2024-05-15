package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.ostale.PredajaKviza;
import com.example.demo.ostale.RezultatiPitanja;
import com.example.demo.services.KorisnikService;
import com.example.demo.services.KvizService;
import com.example.demo.services.PitanjeService;
import com.example.demo.services.RezultatiService;

import jakarta.servlet.http.HttpSession;
import model.Korisnik;
import model.Kviz;
import model.Pitanje;

@Controller
public class KvizController {

	@Autowired
	private KvizService ks;
	
	@Autowired
	private PitanjeService ps;
	
	@Autowired
	private KorisnikService us;
	
	@Autowired
	private RezultatiService rs;
	
	@GetMapping("/listaKvizova")
	public String getAllKvizovi(Model model) {
		List<Kviz> kvizovi = ks.getAllKvizovi();

	    model.addAttribute("kvizovi", kvizovi);
		
		return "listaKvizova";
	}
	
	@GetMapping("/resavanjeKviza/{kvizId}")
	public String getKvizById(@PathVariable int kvizId, Model model) {
		Kviz kviz = ks.getKvizById(kvizId);
		
		List<Pitanje> pitanja = ps.getPitanjaZaKviz(kvizId);
		
		model.addAttribute("kviz", kviz);
		model.addAttribute("pitanja", pitanja);
		model.addAttribute("predajaKviza", new PredajaKviza());
		
		return "resavanjeKviza";
	}
	
	@PostMapping("/kviz/predajaKviza")
	public String predajKviz(@ModelAttribute("predajaKviza") PredajaKviza predajaKviza, 
							@RequestParam("kvizId") int kvizId,
							Model model, HttpSession session) {
		
		Map<Integer, String> odabraneOpcije = predajaKviza.getOdabranaOpcija();
		List<RezultatiPitanja> rezultatiPitanja = new ArrayList<>();
		
		String username = (String) session.getAttribute("username");
		Korisnik user = us.getKorisnici(username);
		Kviz kviz = ks.getKvizById(kvizId);
		
		int skor = 0;
		
		for (Map.Entry<Integer, String> map : odabraneOpcije.entrySet()) {
			Integer pitanjeId = map.getKey();
			String odabranaOpcija = map.getValue(); 
			
			Pitanje pitanje = ps.getpitanje(pitanjeId);
			
			boolean tacno = odabranaOpcija != null && pitanje != null && odabranaOpcija.equals(pitanje.getTacnaOpcija());
			RezultatiPitanja rp = new RezultatiPitanja(pitanje, odabranaOpcija, tacno);
			rezultatiPitanja.add(rp);
			
			if (tacno) {
				skor++;
			}
			
		}
		
		model.addAttribute("rezultatiPitanja", rezultatiPitanja);
		model.addAttribute("skor", skor);
		
		rs.saveRezultati(user, kviz, skor);
		
		return "rezultati";
		
	}
	
	@PostMapping("/lajkujKviz")
	public String lajkujKviz(@RequestParam("kvizId") int kvizId) {
		
		Kviz kviz = ks.getKvizById(kvizId);
		
		if (kviz != null) {
			int lajk = kviz.getOmiljeni();
			lajk++;
			kviz.setOmiljeni(lajk);
			ks.saveKviz(kviz);
		}
		
		return "redirect:/topKvizovi";
		
	}
	
	@GetMapping("/topKvizovi")
	public String topKvizovi(Model model) {
		List<Kviz> topKvizovi = ks.topKvizovi();
		model.addAttribute("topKvizovi", topKvizovi);
		return "topKvizovi";
	}
	
}
