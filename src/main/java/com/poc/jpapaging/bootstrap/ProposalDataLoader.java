package com.poc.jpapaging.bootstrap;

import com.github.javafaker.Faker;
import com.poc.jpapaging.model.Proposal;
import com.poc.jpapaging.repository.ProposalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;


@Component
public class ProposalDataLoader implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ProposalRepository proposalRepository;

    private final Faker faker;

    public ProposalDataLoader(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
        this.faker = new Faker();
    }

  @Override
  public void run(String... args) throws Exception {
    logger.info("Loading Proposal Data....");
    List<Proposal> proposals =
        IntStream.rangeClosed(1, 500)
            .mapToObj(
                i ->
                    new Proposal(
                        faker.number().numberBetween(1000,5000),
                        faker.number().numberBetween(1000,5000),
                        faker.book().title(),
                        faker.name().fullName(),
                        faker.date().birthday()))
            .toList();
    proposalRepository.saveAll(proposals);
  }
}
