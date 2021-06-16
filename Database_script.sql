-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 16-Jun-2021 às 23:22
-- Versão do servidor: 10.4.13-MariaDB
-- versão do PHP: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `url`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_urls`
--

CREATE TABLE `tb_urls` (
  `id` int(11) NOT NULL,
  `url` varchar(200) NOT NULL,
  `url_encurtada` varchar(35) DEFAULT NULL,
  `data_url` date DEFAULT NULL,
  `codigo_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_urls`
--

INSERT INTO `tb_urls` (`id`, `url`, `url_encurtada`, `data_url`, `codigo_usuario`) VALUES
(11, 'https://www.linkedin.com/in/alefe-oliveira-29315a163/', '86cd9c5c', '2021-06-16', 1),
(12, 'https://pt.stackoverflow.com/questions/514407/para-que-serve-e-como-definir-a-prop-key-no-react', 'fe30d742', '2021-06-16', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_usuario`
--

CREATE TABLE `tb_usuario` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `senha` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_usuario`
--

INSERT INTO `tb_usuario` (`id`, `nome`, `email`, `senha`) VALUES
(1, 'alefe', 'alefe@teste.com', '123456');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tb_urls`
--
ALTER TABLE `tb_urls`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `url_encurtada` (`url_encurtada`);

--
-- Índices para tabela `tb_usuario`
--
ALTER TABLE `tb_usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_urls`
--
ALTER TABLE `tb_urls`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `tb_usuario`
--
ALTER TABLE `tb_usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
