package com.codeup.yadlister;

import com.codeup.yadlister.models.Ad;
import com.codeup.yadlister.repositories.AdRepository;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@DatabaseSetup("classpath:ad-test-datasets.xml")
public class AdsRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AdRepository adRepository;

    @Test
    public void testCreateAd(){
        Ad ad = new Ad();
        ad.setTitle("Another PS4");
        ad.setDescription("used for a year");
        Ad newAd = entityManager.persist(ad);
        assertThat(newAd.getTitle()).isEqualTo(ad.getTitle());
    }

    @Test
    public void testReadAd(){
        Ad foundAd = adRepository.findByTitle("PS4");
        assertThat(foundAd).isNotNull();
    }

    @Test
    public void testUpdateAd(){
        Ad existingAd = adRepository.findByTitle("PS4");
        String newTitle = "Another Xbox";
        existingAd.setTitle(newTitle);
        entityManager.persist(existingAd);
        assertThat(adRepository.findByTitle(newTitle)).isNotNull();
    }

    @Test
    public void testDeleteAd(){
        Ad existingAd = adRepository.findByTitle("XBOX");
        entityManager.remove(existingAd);
        assertThat(adRepository.findByTitle("XBOX")).isNull();
    }

    @Test
    public void testAllAds(){
        assertThat(adRepository.count()).isGreaterThan(0);
    }

}
