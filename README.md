# Problema do Jantar dos Filósofos

## Descrição

Cinco filósofos estão sentados em torno de uma mesa redonda. Cada um pode **pensar** ou **comer**. Para comer, um filósofo precisa de dois pauzinhos, um à sua esquerda e um à sua direita. Se ambos os pauzinhos estão disponíveis, o filósofo pode comer; caso contrário, ele deve esperar.
<br>

<div align="center">
    <img width="503" alt="Figura-35-Rede-de-Petri-Ordinaria-para-o-problema-do-jantar-dos-filosofos-Portanto-os" src="https://github.com/user-attachments/assets/fbe88170-7ab2-4ba0-acd6-390d305f2954">
</div>

## Objetivos

- **Evitar Deadlock**: Nenhum filósofo deve ficar preso esperando indefinidamente por recursos.
- **Evitar Starvation**: Garantir que todos os filósofos tenham a chance de comer.
- **Prevenir Condições de Corrida**: Evitar comportamentos inesperados devido à sincronização inadequada.

## Solução Típica

- **Semáforos ou Mutexes**: Usados para controlar o acesso aos pauzinhos.
- **Lógica de Aquisição e Liberação**: Cada filósofo tenta adquirir ambos os pauzinhos antes de comer. Se não conseguir, libera os pauzinhos que já pegou e tenta novamente depois de um tempo.

## Como foi solucionado
- **Semáforos junto com a lógica de aquisição e liberação**

## Implementação

- **Filósofos**: Representam threads que tentam comer.
- **Pauzinhos**: Recursos compartilhados que precisam ser gerenciados para evitar conflitos.
- **Controle de Sincronização**: Utilização de mecanismos para garantir que dois filósofos não peguem o mesmo pauzinho ao mesmo tempo.

## Documentação
- Documentação de toda a implementação: <a href="https://documentation-philosophers-dinner.netlify.app/">Documentação</a> 

Este problema é uma introdução clássica à sincronização e concorrência em programação e sistemas operacionais.
