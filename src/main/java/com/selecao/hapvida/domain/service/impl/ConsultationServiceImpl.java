package com.selecao.hapvida.domain.service.impl;

import com.selecao.hapvida.domain.exception.EntityNotFoundException;
import com.selecao.hapvida.domain.model.Animal;
import com.selecao.hapvida.domain.model.Consultation;
import com.selecao.hapvida.domain.model.Veterinary;
import com.selecao.hapvida.domain.repository.ConsultationRepository;
import com.selecao.hapvida.domain.service.GenericService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ConsultationServiceImpl implements GenericService<Consultation> {

  @Autowired private ConsultationRepository consultationRepository;

  @Autowired private GenericService<Animal> animalService;

  @Autowired private GenericService<Veterinary> veterinaryService;

  @Override
  public Page<Consultation> findAll(int page, int size) {
    return consultationRepository.findAll(PageRequest.of(page, size));
  }

  @Override
  public Consultation findById(long id) {
    return findConsultation(id);
  }

  @Override
  public Consultation save(Consultation consultation) {
    animalService.findById(consultation.getAnimal().getId());
    veterinaryService.findById(consultation.getVeterinary().getId());
    return consultationRepository.save(consultation);
  }

  @Override
  public Consultation update(Consultation consultationUpdated, long idConsultationToUpdate) {
    Consultation consultationToUpdate = findConsultation(idConsultationToUpdate);
    BeanUtils.copyProperties(consultationUpdated, consultationToUpdate, "id", "animal", "veterinary");
    return consultationRepository.save(consultationToUpdate);
  }

  @Override
  public void delete(long id) {
    consultationRepository.delete(findConsultation(id));
  }

  private Consultation findConsultation(long id) {
    return consultationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
  }
}
