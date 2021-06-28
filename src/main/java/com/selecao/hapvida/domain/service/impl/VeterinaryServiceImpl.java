package com.selecao.hapvida.domain.service.impl;

import com.selecao.hapvida.domain.exception.EntityNotFoundException;
import com.selecao.hapvida.domain.model.Veterinary;
import com.selecao.hapvida.domain.repository.VeterinaryRepository;
import com.selecao.hapvida.domain.service.GenericService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class VeterinaryServiceImpl implements GenericService<Veterinary> {

  @Autowired private VeterinaryRepository veterinaryRepository;

  @Override
  public Page<Veterinary> findAll(int page, int size) {
    return veterinaryRepository.findAll(PageRequest.of(page, size));
  }

  @Override
  public Veterinary findById(long id) {
    return findVeterinary(id);
  }

  @Override
  public Veterinary save(Veterinary veterinary) {
    return veterinaryRepository.save(veterinary);
  }

  @Override
  public Veterinary update(Veterinary veterinaryUpdated, long idVeterinaryToUpdate) {
    Veterinary veterinaryToUpdate = findVeterinary(idVeterinaryToUpdate);
    BeanUtils.copyProperties(veterinaryUpdated, veterinaryToUpdate, "id");
    return veterinaryRepository.save(veterinaryToUpdate);
  }

  @Override
  public void delete(long id) {
    veterinaryRepository.delete(findVeterinary(id));
  }

  private Veterinary findVeterinary(long id) {
    return veterinaryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
  }
}
