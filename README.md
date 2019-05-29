# serverless-demo
[![Build Status](https://travis-ci.org/uio-bmi/serverless-demo.svg?branch=master)](https://travis-ci.org/uio-bmi/serverless-demo)

## Demo project of AWS serverless application

### Application
Demo application is written in Kotlin and uses [Serverless](https://serverless.com/) framework for enabling AWS serverless deployment. [Smith–Waterman algorithm](https://en.wikipedia.org/wiki/Smith%E2%80%93Waterman_algorithm) algorithm is implemented as an example:
> The **Smith–Waterman algorithm** performs local sequence alignment; that is, for determining similar regions between two strings of nucleic acid sequences or protein sequences. Instead of looking at the entire sequence, the Smith–Waterman algorithm compares segments of all possible lengths and optimizes the similarity measure.

Powered by: [![BioJava](https://biojava.org/images/logo/logo_100.png)](https://biojava.org/)

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

**serverless-demo** alignment: https://7zjp8jut08.execute-api.eu-north-1.amazonaws.com/dev/alignment?uniProteinId1=P69905&uniProteinId2=P68871

**Execution time**: 848.49 ms

**Result**:
```
CLUSTAL W MSA from BioJava

P69905    LSPADKTNVKAAWGKVGAHAGEYGAEALERMFLSFPTTKTYFPHF-DLS-----HGSAQV  56
          |.| .|. | | ||||  .  | | ||| |. . .| |. .|  | |||      |. .|
P68871    LTPEEKSAVTALWGKV--NVDEVGGEALGRLLVVYPWTQRFFESFGDLSTPDAVMGNPKV  61

P69905    KGHGKKVADALTNAVAHVDDMPNALSALSDLHAHKLRVDPVNFKLLSHCLLVTLAAHLPA 116
          | |||||  | .. .||.|..    . ||.||  || ||| ||.|| . |.  || |   
P68871    KAHGKKVLGAFSDGLAHLDNLKGTFATLSELHCDKLHVDPENFRLLGNVLVCVLAHHFGK 121

P69905    EFTPAVHASLDKFLASVSTVLTSKY 141
          |||| |.|.  | .| |.  |  ||
P68871    EFTPPVQAAYQKVVAGVANALAHKY 146
```

**Available extra options**:

| Parameter           | Type   | Available values                       | Default value  |
|---------------------|--------|----------------------------------------|----------------|
| gapOpenPenalty      | Int    |                                        | 10             |
| gapExtensionPenalty | Int    |                                        | 1              |
| format              | String | ALN, CLUSTALW, FASTA, GCG, MSF, PDBWEB | CLUSTALW       |
