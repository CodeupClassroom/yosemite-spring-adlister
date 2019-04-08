package com.codeup.yadlister;

import com.codeup.yadlister.models.Ad;
import com.codeup.yadlister.repositories.AdRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdsRepositoryTests {

    private String title = "PS4 PRO";
    private Ad ad;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AdRepository adRepository;

    @Before
    public void setUp(){
        ad = new Ad();
        ad.setTitle(title);
        ad.setDescription("used for a year");
    }

    @Test
    public void testAllNoResults(){
        assertThat(adRepository.count()).isEqualTo(0);
    }

    @Test
    public void testAllPlentyResults(){
        assertThat(adRepository.count()).isGreaterThan(0);
    }

    @Test
    public void testFindByTitle(){
        entityManager.persist(ad);
        Ad foundAd = adRepository.findByTitle(this.title);
        assertThat(foundAd.getTitle())
                .isEqualTo(ad.getTitle());
    }

    @Test
    public void testUpdateAd(){
        String newTitle = "Xbox";
        ad.setTitle(newTitle);
        entityManager.persist(ad);
        assertThat(ad.getTitle()).isEqualTo(adRepository.findByTitle(newTitle).getTitle());
    }

}
