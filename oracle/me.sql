-----------------------------------------------------
-- Export file for user ME                         --
-- Created by Administrator on 2018/6/21, 15:14:55 --
-----------------------------------------------------

set define off
spool me.log

prompt
prompt Creating table P_FOSTERFAMILY
prompt =============================
prompt
create table ME.P_FOSTERFAMILY
(
  f_id                  NUMBER(10) not null,
  f_accountname         VARCHAR2(100) not null,
  f_password            VARCHAR2(20) not null,
  f_adoptername         VARCHAR2(100) not null,
  f_adoptersex          CHAR(3) not null,
  f_fosterexperience    VARCHAR2(1000),
  f_contactway          VARCHAR2(20) not null,
  f_address             VARCHAR2(200) not null,
  f_familyphoto         VARCHAR2(100),
  f_requeststatus       VARCHAR2(20) not null,
  f_typerange           VARCHAR2(200) not null,
  f_feedbackinformation VARCHAR2(1000)
)
tablespace MYSPACE
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table ME.P_FOSTERFAMILY
  add constraint PK_P_FOSTERFAMILY_F_ID primary key (F_ID)
  using index 
  tablespace MYSPACE
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table ME.P_FOSTERFAMILY
  add unique (F_ACCOUNTNAME)
  using index 
  tablespace MYSPACE
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table P_FOSTERUSER
prompt ===========================
prompt
create table ME.P_FOSTERUSER
(
  fu_id                  NUMBER(10) not null,
  fu_accountname         VARCHAR2(100) not null,
  fu_password            VARCHAR2(20) not null,
  fu_fosterusername      VARCHAR2(100) not null,
  fu_fosterusersex       CHAR(3) not null,
  fu_contactway          VARCHAR2(20) not null,
  fu_address             VARCHAR2(200) not null,
  fu_requeststatus       VARCHAR2(20) not null,
  fu_feedbackinformation VARCHAR2(1000)
)
tablespace MYSPACE
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table ME.P_FOSTERUSER
  add constraint PK_P_FOSTERUSER_U_ID primary key (FU_ID)
  using index 
  tablespace MYSPACE
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table ME.P_FOSTERUSER
  add unique (FU_ACCOUNTNAME)
  using index 
  tablespace MYSPACE
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table P_HOSPITAL
prompt =========================
prompt
create table ME.P_HOSPITAL
(
  h_id                  NUMBER(10) not null,
  h_hospitalname        VARCHAR2(100) not null,
  h__contactway         VARCHAR2(20) not null,
  h_address             VARCHAR2(200) not null,
  h_businesshours       VARCHAR2(100),
  h_hospitalphoto       VARCHAR2(100),
  h_serviceintroduction VARCHAR2(1000)
)
tablespace MYSPACE
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table ME.P_HOSPITAL
  add constraint PK_P_HOSPITAL_H_ID primary key (H_ID)
  using index 
  tablespace MYSPACE
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table ME.P_HOSPITAL
  add unique (H_HOSPITALNAME)
  using index 
  tablespace MYSPACE
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table P_INFORMATION
prompt ============================
prompt
create table ME.P_INFORMATION
(
  i_id            NUMBER(10) not null,
  i_environment   VARCHAR2(1000),
  i_fostercare    NUMBER(10,2),
  i_pickupservice NUMBER(10,2),
  i_describe      VARCHAR2(4000),
  i_needtoknow    VARCHAR2(1000),
  i_cshotline     VARCHAR2(20),
  i_fosterstyle   VARCHAR2(20) not null,
  i_fosterplaceid NUMBER(10) not null
)
tablespace MYSPACE
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table ME.P_INFORMATION
  add constraint PK_P_INFORMATION_I_ID primary key (I_ID)
  using index 
  tablespace MYSPACE
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table ME.P_INFORMATION
  add unique (I_FOSTERPLACEID)
  using index 
  tablespace MYSPACE
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table P_MANAGER
prompt ========================
prompt
create table ME.P_MANAGER
(
  m_id          NUMBER(10) not null,
  m_accountname VARCHAR2(20) not null,
  m_password    VARCHAR2(20) not null,
  m_managername VARCHAR2(20) not null
)
tablespace MYSPACE
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table ME.P_MANAGER
  add constraint PK_P_MANAGER_M_ID primary key (M_ID)
  using index 
  tablespace MYSPACE
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table ME.P_MANAGER
  add unique (M_ACCOUNTNAME)
  using index 
  tablespace MYSPACE
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table P_ORDER
prompt ======================
prompt
create table ME.P_ORDER
(
  o_id            NUMBER(10) not null,
  u_id            NUMBER(10) not null,
  p_id            NUMBER(10) not null,
  o_fosterstyle   VARCHAR2(20) not null,
  o_fosterplaceid NUMBER(10) not null,
  o_fosterday     NUMBER(10) not null,
  o_orderdate     DATE not null,
  o_orderstatus   VARCHAR2(20) not null
)
tablespace MYSPACE
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table ME.P_ORDER
  add constraint PK_P_ORDER_O_ID primary key (O_ID)
  using index 
  tablespace MYSPACE
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table P_PET
prompt ====================
prompt
create table ME.P_PET
(
  p_id      NUMBER(10) not null,
  p_petname VARCHAR2(20) not null,
  p_sex     CHAR(3),
  p_type    VARCHAR2(20) not null,
  fu_id     NUMBER(10) not null
)
tablespace MYSPACE
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table ME.P_PET
  add constraint PK_P_PET_P_ID primary key (P_ID)
  using index 
  tablespace MYSPACE
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table P_PETSHOP
prompt ========================
prompt
create table ME.P_PETSHOP
(
  ps_id                  NUMBER(10) not null,
  ps_accountname         VARCHAR2(100) not null,
  ps_password            VARCHAR2(20) not null,
  ps_petshopname         VARCHAR2(100) not null,
  ps_contactway          VARCHAR2(20) not null,
  ps_address             VARCHAR2(200) not null,
  ps_petshopphoto        VARCHAR2(100),
  ps_requeststatus       VARCHAR2(20) not null,
  ps_typerange           VARCHAR2(200) not null,
  ps_feedbackinformation VARCHAR2(1000)
)
tablespace MYSPACE
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table ME.P_PETSHOP
  add constraint PK_P_PETSHOP_PS_ID primary key (PS_ID)
  using index 
  tablespace MYSPACE
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table ME.P_PETSHOP
  add unique (PS_ACCOUNTNAME)
  using index 
  tablespace MYSPACE
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_USER
prompt =====================
prompt
create table ME.T_USER
(
  id   NUMBER not null,
  name VARCHAR2(50)
)
tablespace MYSPACE
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
create index ME.IND_ID on ME.T_USER (NAME)
  tablespace MYSPACE
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table ME.T_USER
  add constraint PK_T_USER_ID primary key (ID)
  using index 
  tablespace MYSPACE
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating sequence SEQ_P_FOSTERFAMILY_F_ID
prompt =========================================
prompt
create sequence ME.SEQ_P_FOSTERFAMILY_F_ID
minvalue 1
maxvalue 999999
start with 181
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_P_FOSTERUSER_FU_ID
prompt ========================================
prompt
create sequence ME.SEQ_P_FOSTERUSER_FU_ID
minvalue 1
maxvalue 999999
start with 141
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_P_HOSPITAL_H_ID
prompt =====================================
prompt
create sequence ME.SEQ_P_HOSPITAL_H_ID
minvalue 1
maxvalue 999999
start with 81
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_P_INFORMATION_I_ID
prompt ========================================
prompt
create sequence ME.SEQ_P_INFORMATION_I_ID
minvalue 1
maxvalue 999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_P_MANAGER_M_ID
prompt ====================================
prompt
create sequence ME.SEQ_P_MANAGER_M_ID
minvalue 1
maxvalue 999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_P_ORDER_O_ID
prompt ==================================
prompt
create sequence ME.SEQ_P_ORDER_O_ID
minvalue 1
maxvalue 999999
start with 401
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_P_PETSHOP_PS_ID
prompt =====================================
prompt
create sequence ME.SEQ_P_PETSHOP_PS_ID
minvalue 1
maxvalue 999999
start with 121
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_P_PET_P_ID
prompt ================================
prompt
create sequence ME.SEQ_P_PET_P_ID
minvalue 1
maxvalue 999999
start with 241
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_USER_ID
prompt ===============================
prompt
create sequence ME.SEQ_T_USER_ID
minvalue 1
maxvalue 999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating view V_P_FOSTERFAMILY
prompt ==============================
prompt
create or replace force view me.v_p_fosterfamily as
select "F_ID","F_ACCOUNTNAME","F_PASSWORD","F_ADOPTERNAME","F_ADOPTERSEX","F_FOSTEREXPERIENCE","F_CONTACTWAY","F_ADDRESS","F_FAMILYPHOTO","F_REQUESTSTATUS","F_TYPERANGE","F_FEEDBACKINFORMATION" from p_fosterfamily;


spool off
