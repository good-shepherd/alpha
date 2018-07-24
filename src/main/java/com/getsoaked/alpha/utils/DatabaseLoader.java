package com.getsoaked.alpha.utils;

import com.getsoaked.alpha.entities.Beer;
import com.getsoaked.alpha.entities.Brewery;
import com.getsoaked.alpha.repositories.BeerRepository;
import com.getsoaked.alpha.repositories.BreweryRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DatabaseLoader implements CommandLineRunner {

    BreweryRepository breweryRepository;
    BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {
        // beerRepository.deleteAll();
        // breweryRepository.deleteAll();
        breweries();
        beers();
    }

    private void beers() {
        beerRepository.save(Beer.builder()
                .brewery(breweryRepository.getOne(1l))
                .abv(4.6f)
                .description("쌀이 첨가된 맥주입니다. 깔끔하고 담백하여 부드럽고 마시기 편합니다.")
                .name("미노리 세션")
                .type(1)
                .build());
        beerRepository.save(Beer.builder()
                .brewery(breweryRepository.getOne(1l))
                .abv(5f)
                .description("벨기에 농주인 맥주 스타일 '세종'에 강릉을 상징하는 '솔'을 가미했습니다.")
                .name("파인 시티 세종")
                .type(2)
                .build());
        beerRepository.save(Beer.builder()
                .brewery(breweryRepository.getOne(1l))
                .abv(5.5f)
                .description("국화나 산초가 가미되어 국화향 바나나향 스파이시함이 어우러진 부드러운 밀맥주입니다.")
                .name("즈므 블랑")
                .type(3)
                .build());
        beerRepository.save(Beer.builder()
                .brewery(breweryRepository.getOne(1l))
                .abv(6.1f)
                .description("볶은 맥아 향이 가볍게 느껴져서 마시기 편하고 균형 잡힌 붉은빛의 맥주입니다.")
                .name("백일홍 레드 에일")
                .type(4)
                .build());
        beerRepository.save(Beer.builder()
                .brewery(breweryRepository.getOne(1l))
                .abv(6.1f)
                .description("하슬라는 '큰 바다'라는 뜻의 강릉 옛 이름입니다.")
                .name("하슬라 IPA")
                .type(5)
                .build());
        beerRepository.save(Beer.builder()
                .brewery(breweryRepository.getOne(1l))
                .abv(7f)
                .description("깉은 커피 향과 비교적 높은 알코올 도수가 조화를 이루는 묵직한 흑맥주 입니다.")
                .name("오죽 스타우트")
                .type(6)
                .build());
        beerRepository.save(Beer.builder()
                .brewery(breweryRepository.getOne(1l))
                .abv(5.8f)
                .description("달큰한 향과 함께 새콤하고 고소한 맛을 느낄 수 있는 깔끔한 사워 에일입니다.")
                .name("황매실 사워")
                .type(7)
                .build());
        beerRepository.save(Beer.builder()
                .brewery(breweryRepository.getOne(1l))
                .abv(9f)
                .description("아메리칸 스타일의 더블 IPA입니다.")
                .name("경포 더블 IPA")
                .type(8)
                .build());
        beerRepository.save(Beer.builder()
                .brewery(breweryRepository.getOne(1l))
                .abv(5.9f)
                .description("북미산 신선한 홉을 사용한 아메리칸 페일 에일 스타일입니다.")
                .name("대굴령 페일 에일")
                .type(9)
                .build());
    }

    private void breweries() {
        breweryRepository.save(Brewery.builder()
                .address("강원도 강릉시 경강로 1961")
                .name("버드나무 브루어리")
                .phone("033-920-9380")
                .x(37.748122)
                .y(128.884357)
                .build());
        breweryRepository.save(Brewery.builder()
                .address("서울특별시 성동구 성수동1가 27-12")
                .name("어메이징 브루잉 컴퍼니")
                .phone("02-465-5208")
                .x(37.542863)
                .y(127.049393)
                .build());
    }
}
