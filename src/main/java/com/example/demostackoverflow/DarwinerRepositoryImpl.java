package com.example.demostackoverflow;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DarwinerRepositoryImpl implements CrudService<Darwiner, Long> {

    private final TestRepository darwinerRepository;

    public DarwinerRepositoryImpl(TestRepository darwinerRepository) {
        this.darwinerRepository = darwinerRepository;
    }


    @Override
    public Set<Darwiner> findAll() {
        Set<Darwiner> darwins = new HashSet<>();
        darwinerRepository.findAll().forEach(darwins::add);
        return darwins;
    }

    @Override
    public Darwiner findById(Long id) {
        return darwinerRepository.findById(id).orElse(new Darwiner());
    }

    @Override
    public Darwiner save(Darwiner darwiner) {
        return darwinerRepository.save(darwiner);
    }

    @Override
    public void deleteById(Long darwiner) {
        darwinerRepository.deleteById(darwiner);
    }
}
