
package com.getsoaked.alpha.utils;

import com.getsoaked.alpha.entities.*;
import com.getsoaked.alpha.repositories.BeerMenuRepository;
import com.getsoaked.alpha.repositories.BeerRepository;
import com.getsoaked.alpha.repositories.BreweryRepository;
import com.getsoaked.alpha.repositories.PlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DatabaseLoader implements CommandLineRunner {

    BreweryRepository breweryRepository;
    BeerRepository beerRepository;
    BeerMenuRepository beerMenuRepository;
    PlaceRepository placeRepository;

    @Override
    public void run(String... args) throws Exception {
        breweries();
        beers();
        places();
        menus();
    }

    private void menus() {
        Long place, beer;
        place = 14l;
        beer = 4l;
        beerMenuRepository.save(BeerMenu.builder()
                .id(CompositePK.builder()
                        .placeId(place)
                        .beerId(beer)
                        .build())
                .place(placeRepository.getOne(place))
                .beer(beerRepository.getOne(beer))
                .status(StatusType.AVAILABLE)
                .draftPPM(7000f/450f)
                .build());
        beer = 5l;
        beerMenuRepository.save(BeerMenu.builder()
                .id(CompositePK.builder()
                        .placeId(place)
                        .beerId(beer)
                        .build())
                .place(placeRepository.getOne(place))
                .beer(beerRepository.getOne(beer))
                .status(StatusType.AVAILABLE)
                .draftPPM(7000f/400f)
                .build());
        beer = 6l;
        beerMenuRepository.save(BeerMenu.builder()
                .id(CompositePK.builder()
                        .placeId(place)
                        .beerId(beer)
                        .build())
                .place(placeRepository.getOne(place))
                .beer(beerRepository.getOne(beer))
                .status(StatusType.AVAILABLE)
                .draftPPM(6000f/400f)
                .build());
        beer = 7l;
        beerMenuRepository.save(BeerMenu.builder()
                .id(CompositePK.builder()
                        .placeId(place)
                        .beerId(beer)
                        .build())
                .place(placeRepository.getOne(place))
                .beer(beerRepository.getOne(beer))
                .status(StatusType.AVAILABLE)
                .draftPPM(8000f/450f)
                .build());
        beer = 8l;
        beerMenuRepository.save(BeerMenu.builder()
                .id(CompositePK.builder()
                        .placeId(place)
                        .beerId(beer)
                        .build())
                .place(placeRepository.getOne(place))
                .beer(beerRepository.getOne(beer))
                .status(StatusType.AVAILABLE)
                .draftPPM(7000f/400f)
                .build());
        beer = 9l;
        beerMenuRepository.save(BeerMenu.builder()
                .id(CompositePK.builder()
                        .placeId(place)
                        .beerId(beer)
                        .build())
                .place(placeRepository.getOne(place))
                .beer(beerRepository.getOne(beer))
                .status(StatusType.AVAILABLE)
                .draftPPM(8000f/400f)
                .build());
        beer = 10l;
        beerMenuRepository.save(BeerMenu.builder()
                .id(CompositePK.builder()
                        .placeId(place)
                        .beerId(beer)
                        .build())
                .place(placeRepository.getOne(place))
                .beer(beerRepository.getOne(beer))
                .status(StatusType.AVAILABLE)
                .draftPPM(7000f/400f)
                .build());
        beer = 11l;
        beerMenuRepository.save(BeerMenu.builder()
                .id(CompositePK.builder()
                        .placeId(place)
                        .beerId(beer)
                        .build())
                .place(placeRepository.getOne(place))
                .beer(beerRepository.getOne(beer))
                .status(StatusType.AVAILABLE)
                .draftPPM(9000f/400f)
                .build());
        beer = 12l;
        beerMenuRepository.save(BeerMenu.builder()
                .id(CompositePK.builder()
                        .placeId(place)
                        .beerId(beer)
                        .build())
                .place(placeRepository.getOne(place))
                .beer(beerRepository.getOne(beer))
                .status(StatusType.AVAILABLE)
                .draftPPM(7000f/450f)
                .build());
    }

    private void places() {
        placeRepository.save(Place.builder()
                .type(PlaceType.PUB)
                .x(37.385984)
                .y(127.111410)
                .address("경기도 성남시 분당구 백현동 판교역로10번길 27")
                .phone("031-703-9707")
                .name("올드스탠드")
                .build());
        placeRepository.save(Place.builder()
                .type(PlaceType.TASTING_ROOM)
                .address("강원도 강릉시 경강로 1961")
                .name("버드나무 브루어리")
                .phone("033-920-9380")
                .x(37.748122)
                .y(128.884357)
                .build());
    }

    private void beers() {
        beerRepository.save(Beer.builder()
                .brewery(breweryRepository.getOne(1l))
                .abv(4.6f)
                .description("쌀이 첨가된 맥주입니다. 깔끔하고 담백하여 부드럽고 마시기 편합니다.")
                .name("미노리 세션")
                .type(BeerType.SESSION_IPA)
                .build());
        beerRepository.save(Beer.builder()
                .brewery(breweryRepository.getOne(1l))
                .abv(5f)
                .description("벨기에 농주인 맥주 스타일 '세종'에 강릉을 상징하는 '솔'을 가미했습니다.")
                .name("파인 시티 세종")
                .type(BeerType.SAISON)
                .build());
        beerRepository.save(Beer.builder()
                .brewery(breweryRepository.getOne(1l))
                .abv(5.5f)
                .description("국화나 산초가 가미되어 국화향 바나나향 스파이시함이 어우러진 부드러운 밀맥주입니다.")
                .name("즈므 블랑")
                .type(BeerType.BLANC)
                .build());
        beerRepository.save(Beer.builder()
                .brewery(breweryRepository.getOne(1l))
                .abv(6.1f)
                .description("볶은 맥아 향이 가볍게 느껴져서 마시기 편하고 균형 잡힌 붉은빛의 맥주입니다.")
                .name("백일홍 레드 에일")
                .type(BeerType.ALE)
                .build());
        beerRepository.save(Beer.builder()
                .brewery(breweryRepository.getOne(1l))
                .abv(6.1f)
                .description("하슬라는 '큰 바다'라는 뜻의 강릉 옛 이름입니다.")
                .name("하슬라 IPA")
                .type(BeerType.IPA)
                .build());
        beerRepository.save(Beer.builder()
                .brewery(breweryRepository.getOne(1l))
                .abv(7f)
                .description("깉은 커피 향과 비교적 높은 알코올 도수가 조화를 이루는 묵직한 흑맥주 입니다.")
                .name("오죽 스타우트")
                .type(BeerType.STOUT)
                .build());
        beerRepository.save(Beer.builder()
                .brewery(breweryRepository.getOne(1l))
                .abv(5.8f)
                .description("달큰한 향과 함께 새콤하고 고소한 맛을 느낄 수 있는 깔끔한 사워 에일입니다.")
                .name("황매실 사워")
                .type(BeerType.SOUR_ALE)
                .build());
        beerRepository.save(Beer.builder()
                .brewery(breweryRepository.getOne(1l))
                .abv(9f)
                .description("아메리칸 스타일의 더블 IPA입니다.")
                .name("경포 더블 IPA")
                .type(BeerType.DOUBLE_IPA)
                .build());
        beerRepository.save(Beer.builder()
                .brewery(breweryRepository.getOne(1l))
                .abv(5.9f)
                .description("북미산 신선한 홉을 사용한 아메리칸 페일 에일 스타일입니다.")
                .name("대굴령 페일 에일")
                .type(BeerType.PALE_ALE)
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
        breweryRepository.save(Brewery.builder()
                .address("경기도 성남시 분당구 판교동 운중로225번길 14-3, 101호(판교동)")
                .name("더부스 판교 브루어리")
                .phone("02-711-4723")
                .x(37.391235)
                .y(127.089032)
                .build());
    }
}

