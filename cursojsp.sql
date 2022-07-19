--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.25
-- Dumped by pg_dump version 9.5.25

-- Started on 2022-07-19 16:59:40

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2103 (class 0 OID 16394)
-- Dependencies: 181
-- Data for Name: model_login; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.model_login (login, senha, id, nome, email, useradmin, usuario_id) FROM stdin;
lucas	admin	1	lucas	lks@lks.com	t	1
admin	admin	2	admin	admin@adm.com	t	1
novo	novo	4	novo	novo@novo.com	f	1
123	123	33	123	123@123.com	f	1
breno123	breno	5	breno	breno@breno.com	f	1
\.


--
-- TOC entry 2115 (class 0 OID 0)
-- Dependencies: 182
-- Name: model_login_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.model_login_id_seq', 5, true);


-- Completed on 2022-07-19 16:59:40

--
-- PostgreSQL database dump complete
--

