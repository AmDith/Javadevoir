package com.ism.Core.Database;

import com.ism.entities.RV;

public interface RVRepoListInt extends Repository<RV> {
  RV selectByDate(String val);
}
