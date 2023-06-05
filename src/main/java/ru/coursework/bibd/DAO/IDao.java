package ru.coursework.bibd.DAO;

import java.util.List;

public interface IDao<T> {
    String path = "'D:\\Projects\\java_pr\\bibd\\src\\main\\resources\\static\\backups\\";
   public List<T> index();
   default public T show(int id){return null;};
   default public T show(String code){return null;};
   public void save(T obj);

   default public T search(String codeOrName){return null;};
   default public T search(int num){return null;};
   default public void update(int id, T updatedObj){};
   default public void update(String  code, T updatedObj){};
   default public void delete(int id){};
   default public void delete(String code){};

   public void backup();
   public void restore();
}
