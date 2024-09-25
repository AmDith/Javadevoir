package com.ism.Core.Database;

import java.util.List;

public interface Repository <A>{
  int insert(A amour);
  List<A> selectAll();
  
}
