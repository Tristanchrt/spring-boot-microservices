package com.sp.database.seeders;

import com.sp.model.Card;
import com.sp.repository.CardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class CardSeeder implements CommandLineRunner {

	@Autowired
	CardRepository cardRepository;

	@Override
	public void run(String... args) throws Exception {
		loadCardData();
	}

	private void loadCardData() {
		if (cardRepository.count() == 0) {
			Card c1 = new Card("Pikachu", "Pokemon electric", "Electric","https://www.pokepedia.fr/images/thumb/7/76/Pikachu-DEPS.png/250px-Pikachu-DEPS.png", "Pokemon", 20, 50, 35, 20, 1,10, false);
			Card c2 = new Card("Pingoleon", "Pokemon eau", "Water", "https://www.pokepedia.fr/images/1/14/Pingol%C3%A9on-DEPS.png","Pokemon", 30, 40, 35, 50, 1,40, false);
			Card c3 = new Card("Salamèche", "Pokemon feu", "Fire", "https://image.jeuxvideo.com/medias-sm/160286/1602862226-7516-artwork.jpg", "Pokemon", 20, 50, 35, 20, 2, 15, false);
			cardRepository.save(c1);
			cardRepository.save(c2);
			cardRepository.save(c3);
		}
	}
}
