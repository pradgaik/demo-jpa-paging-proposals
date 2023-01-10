package com.poc.jpapaging.controller;

import com.poc.jpapaging.model.Proposal;
import com.poc.jpapaging.repository.ProposalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class ProposalController {

  private final ProposalRepository proposalRepository;

  public ProposalController(ProposalRepository proposalRepository) {
    this.proposalRepository = proposalRepository;
  }

  @GetMapping("/proposals")
  public Page<Proposal> findAll(
      @RequestParam int pageNumber,
      @RequestParam int pageSize,
      @RequestParam Sort.Direction sortDirection,
      @RequestParam String... sortByProperties) {
    PageRequest pr =
        PageRequest.of(pageNumber, pageSize).withSort(Sort.by(sortDirection,sortByProperties));
    return proposalRepository.findAll(pr);
  }
}
