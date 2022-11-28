package bsuir.kaf.electroniki.service;

import java.util.List;

import bsuir.kaf.electroniki.model.Mark;

public interface MarkService extends EntityService<Mark>{

    List<Mark> findMarksByCrit(long idCrit);
}
