package com.wgc.todo.exception;

public class DatabaseException extends Exception{
   public DatabaseException() {
       super("数据库错误，请联系相关的管理人员");
   }
   public DatabaseException(String message) {
       super(message);
   }
}
