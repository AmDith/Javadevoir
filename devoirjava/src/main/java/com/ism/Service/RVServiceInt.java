package com.ism.Service;

import com.ism.Core.Database.Service;
import com.ism.entities.RV;

public interface RVServiceInt<T,A> extends Service<T,A> {
  RV search(String phone);
}
