# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table topic (
  id                            bigint auto_increment not null,
  title                         varchar(255),
  contents                      TEXT,
  constraint pk_topic primary key (id)
);


# --- !Downs

drop table if exists topic;

