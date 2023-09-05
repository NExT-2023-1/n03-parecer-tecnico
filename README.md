# Preenchimento de Parecer Técnico

## Contexto

Com a necessidade de gerar documentos referentes a pareceres técnicos provenientes de consertos de equipamentos eletroeletrônicos, existe a necessidade da geração automática desses documentos com suas informações providas a partir da entrada de dados disponibilizados pelas assistências técnicas. Assim, faz-se necessário um sistema que consiga preencher os dados a partir de um template do documento de parecer no formato XLSX.

## Objetivo

Implementar uma API que fornece operações necessárias para:

- Receber dados do parecer técnico e armazenar em uma base de dados.
- Recuperar um documento de parecer técnico em formato XLSX, preenchido automaticamente após recuperar as informações da base de dados pelo identificador do parecer técnico que foi gerado ao ser incluído na base.
- Recuperar a lista de pareceres técnicos na base de dados, considerando a paginação de dados para evitar lentidão na consulta e na recuperação das informações.
- Remover da base de dados um parecer técnico cadastrado previamente.

Validações para as operações deverão ser consideradas na implementação do serviço e deverá retornar uma identificação do problema ocorrido. Validações necessárias:

- Todas as informações do parecer técnico são obrigatórias. (Cliente, Equipamento, Defeito, Texto do Parecer)
- Informações com domínio definido devem apenas aceitar valores válidos.

Em relação às informações do parecer, considerar o seguinte tipo de dados e domínios.

CLIENTE (Texto livre)
EQUIPAMENTO (Smartphone, Smartwatch, TV)
DEFEITO (Placa Oxidada, Tela Trincada, Componente com defeito)
PARECER (Texto livre)

## Referências

- http://poi.apache.org/components/spreadsheet/quick-guide.html 
- https://spring.io/guides/tutorials/rest/
- https://openpyxl.readthedocs.io/en/stable/ 
- https://flask.palletsprojects.com 
