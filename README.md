# serverless-demo
[![Build Status](https://travis-ci.org/uio-bmi/serverless-demo.svg?branch=master)](https://travis-ci.org/uio-bmi/serverless-demo)

## Demo project of AWS serverless application

### Application
Demo application is written in Kotlin and uses [Serverless](https://serverless.com/) framework for enabling AWS serverless deployment. [Smith–Waterman algorithm](https://en.wikipedia.org/wiki/Smith%E2%80%93Waterman_algorithm) algorithm is implemented as an example:
> The **Smith–Waterman algorithm** performs local sequence alignment; that is, for determining similar regions between two strings of nucleic acid sequences or protein sequences. Instead of looking at the entire sequence, the Smith–Waterman algorithm compares segments of all possible lengths and optimizes the similarity measure.

### Requirements
- Java 8
- Maven
- Node.js

### Pre-requisites

#### Serverless CLI
```
npm install -g serverless
```

#### AWS credentials
```
export AWS_ACCESS_KEY_ID=<your-key-here>
export AWS_SECRET_ACCESS_KEY=<your-secret-key-here>
```

### Build
```
mvn install
```

### Deploy 
```
sls deploy --region <your-AWS-region>
```

### Example
Let's take as an example aligment of [Hemoglobin subunit alpha](https://www.uniprot.org/uniprot/P69905) and [Hemoglobin subunit beta](https://www.uniprot.org/uniprot/P68871).

**serverless-demo** alignment: https://7zjp8jut08.execute-api.eu-north-1.amazonaws.com/dev/alignment?uniProteinId1=P00750&uniProteinId2=P68871

**Execution time**: 848.49 ms

**Result**:
```
CLUSTAL W MSA from BioJava

P00750    SAYRGTHSLTESGASCL-------PWNSMIL--IGKVYTAQ----NPSAQALG---LGKH 264
          .|  |  .. | |   |       ||        | . |      ||  .| |   ||  
P68871    TALWGKVNVDEVGGEALGRLLVVYPWTQRFFESFGDLSTPDAVMGNPKVKAHGKKVLGAF  72

P00750    NYCRNPDGDAKPWCHVLKNRRLTWE-----YCDVPSCSTCGLRQYSQPQ-FRIKGGLFAD 318
          .     || |    | | | . |.      .||         . .  |. ||. | .   
P68871    S-----DGLA----H-LDNLKGTFATLSELHCD---------KLHVDPENFRLLGNVLVC 113

P00750    IASH--------PWQAA 327
          . .|        | |||
P68871    VLAHHFGKEFTPPVQAA 130
```

**UniProt alignment**: https://www.uniprot.org/align/

**Execution time**: 15 s

**Result**:
```
CLUSTAL O(1.2.4) multiple sequence alignment

SP|P69905|HBA_HUMAN -MVLSPADKTNVKAAWGKVGAHAGEYGAEALERMFLSFPTTKTYFPHFD------LSHGS 53
SP|P68871|HBB_HUMAN MVHLTPEEKSAVTALWGKVNV--DEVGGEALGRLLVVYPWTQRFFESFGDLSTPDAVMGN 58
                     : *:* :*: *.* ****..  .* *.*** *::: :* *: :*  *.         *.

SP|P69905|HBA_HUMAN AQVKGHGKKVADALTNAVAHVDDMPNALSALSDLHAHKLRVDPVNFKLLSHCLLVTLAAH 113
SP|P68871|HBB_HUMAN PKVKAHGKKVLGAFSDGLAHLDNLKGTFATLSELHCDKLHVDPENFRLLGNVLVCVLAHH 118
                     :**.***** .*:::.:**:*:: .::::**:**..**:*** **:**.: *: .** *

SP|P69905|HBA_HUMAN LPAEFTPAVHASLDKFLASVSTVLTSKYR 142
SP|P68871|HBB_HUMAN FGKEFTPPVQAAYQKVVAGVANALAHKYH 147
                    :  **** *:*: :*.:*.*:..*: **:
```
