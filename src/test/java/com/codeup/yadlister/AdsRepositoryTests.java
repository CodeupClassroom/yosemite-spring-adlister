package com.codeup.yadlister;

import com.codeup.yadlister.models.Ad;
import com.codeup.yadlister.repositories.AdRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
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

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AdRepository adRepository;

    @Test
    public void testFindByTitle(){
        String title = "PS4 PRO";
        Ad ad = new Ad();
        ad.setTitle(title);
        ad.setDescription("used for a year");
        entityManager.persist(ad);
        Ad foundAd = adRepository.findByTitle(title);
        assertThat(foundAd.getTitle())
                .isEqualTo(ad.getTitle());
    }

}
