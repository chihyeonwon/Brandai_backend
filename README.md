# Brandai 서비스 백엔드 프로젝트 <a target="_blank" rel="noopener noreferrer nofollow" href="ㅁㅁㅁㅁ"><img src="https://img.shields.io/badge/Release-1.0.0-ec8034" alt="license" data-canonical-src="https://img.shields.io/badge/Release-1.0.0-ec8034" style="max-width: 100%;"></a>
## 1. 소개


> 디지털 격차를 해소할 수 있는 서비스

현재 소상공인 중에서 디지털 브랜딩과 이커머스 기술을 효과적으로 활용하는 사람은 약 15.4%에 불과합니다. 이 문제를 해결하기 위해 정부는 지자체 예산을 확보하고 다양한 교육 정책을 추진하고 있습니다. 그러나 교육만으로도 해결하기 어려운 다양한 어려움이 존재합니다. 특히 디지털 브랜딩 분야에서는 로고나 상세 페이지 이미지 디자인에 상당한 비용이 소요되며, 상품 정보를 효과적으로 홍보하는 것 역시 어려움을 겪고 있습니다. 이런 상황을 개선하기 위해 저희는 'BranDai'라는 용어에서 파생된 이름으로, 브랜딩과 인공지능(AI)을 결합한 서비스를 개발하게 되었습니다.

<br>
<br>

## 2. 사용 방법

BranDai(브랜다이) 서비스는 사용자가 정말로 이용하기 쉽고 편리하도록 구성했습니다. 왜냐하면 이 서비스 자체로부터 또 다른 디지털 격차를 파생해서는 안되기 때문입니다.
<br>

1. 카카오 소셜 로그인

먼저, 우리 서비스는 카카오 소셜 로그인을 도입했습니다. 실제로 디지털 소외 계층에서 가장 많이 활용되는 서비스가 무엇인지 조사한 결과, 바로 카카오톡이었습니다. 그래서 저희는 카카오 소셜 로그인을 도입함으로써 누구든지 서비스에 접근하는 과정을 더욱 편리하게 만들어주었습니다.

<br>

2. 입력 프롬프트와 결과창

입력 프롬프트에는 카테고리, 브랜드, 상호명, 간단한 소개글, 그리고 무드와 컬러만 입력하시면 됩니다. 이렇게 입력한 값을 기반으로 데이터 전처리를 수행하고 필요한 정보를 추출한 후, OpenAI의 ChatGPT API와 DALL-E API를 활용하여 로고와 상세 설명을 신속히 생성합니다. 그 결과물을 이용하여 상세페이지 이미지를 생성하고 이를 사용자들에게 제공합니다.

<br>
<br>

## 3. 백엔드 이야기

저는 이번 백엔드 개발에서 Spring을 담당했습니다. 다른 팀원들이 작성한 Python 기반의 API 요청 코드를 Java로 변환하여 Spring에 효과적으로 적용했습니다. 더불어 카카오 소셜 로그인에 필요한 API 호출과, OpenAI 비용 절감을 위해 Papago API 호출을 구현했습니다. 또한 저희 서비스의 데이터베이스를 설계하고 직접 코드를 작성하여 구현했습니다.


<img width="804" alt="Database ERD" src="https://github.com/LikeLionHackathon/backend/assets/67568334/8294b3c6-78e0-4926-8a58-00793b7886db">

<br>
<br>

## 4. 패키지 TREE
    📦main
    ┣ 📂generated
    ┣ 📂java
    ┃ ┣ 📂likelion
    ┃ ┃ ┣ 📂hackathon
    ┃ ┃ ┃ ┣ 📂BradingHelper
    ┃ ┃ ┃ ┃ ┣ 📂ApiAccess
    ┃ ┃ ┃ ┃ ┃ ┣ 📂ChatGpt
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ChatGptApiRequester.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ChatGptDataGenerator.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ChatGptPreprocessor.java
    ┃ ┃ ┃ ┃ ┃ ┣ 📂Controller
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DescriptionController.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LogoApiController.java
    ┃ ┃ ┃ ┃ ┃ ┣ 📂Description
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DescriptionPreprocessor.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DescriptionResponse.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DescriptionTemplate.java
    ┃ ┃ ┃ ┃ ┃ ┣ 📂Interfaces
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ApiRequesterInterface.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DataPreprocessorInterface.java
    ┃ ┃ ┃ ┃ ┃ ┣ 📂Logo
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LogoApiRequester.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LogoDataPreprocessor.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LogoGenerator.java
    ┃ ┃ ┃ ┃ ┃ ┣ 📂Papago
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PapagoApiRequester.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PapagoDataPreprocessor.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PapagoTranslator.java
    ┃ ┃ ┃ ┃ ┃ ┣ 📂Prompt
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Description
    ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DescriptionPromptFoam.txt
    ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DescriptionPromptPreprocessor.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DescriptionToStringPrompt.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Interface
    ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PromptPreprocessor.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ToStringPrompt.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂Logo
    ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LogoPromptFoam.txt
    ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LogoPromptPreprocessor.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LogoToStringPrompt.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Prompt.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TranslatePrompt.java
    ┃ ┃ ┃ ┃ ┃ ┣ 📂Security
    ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TokenManager.java
    ┃ ┃ ┃ ┃ ┃ ┗ 📂Utils
    ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜HttpUtils.java
    ┃ ┃ ┃ ┃ ┣ 📂Auth
    ┃ ┃ ┃ ┃ ┃ ┣ 📂Controller
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthController.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜KakaoController.java
    ┃ ┃ ┃ ┃ ┃ ┣ 📂Service
    ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜KakaoService.java
    ┃ ┃ ┃ ┃ ┃ ┗ 📜.DS_Store
    ┃ ┃ ┃ ┃ ┣ 📂Config
    ┃ ┃ ┃ ┃ ┃ ┣ 📜SecurityConfig.java
    ┃ ┃ ┃ ┃ ┃ ┣ 📜SwaggerConfig.java
    ┃ ┃ ┃ ┃ ┃ ┗ 📜WebMvcConfig.java
    ┃ ┃ ┃ ┃ ┣ 📂DataCollection
    ┃ ┃ ┃ ┃ ┃ ┣ 📂Controller
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CardController.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserAccountController.java
    ┃ ┃ ┃ ┃ ┃ ┣ 📂Dao
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CardDao.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserAccountDao.java
    ┃ ┃ ┃ ┃ ┃ ┣ 📂Dto
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CardDto.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DescriptionDto.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserAccountDto.java
    ┃ ┃ ┃ ┃ ┃ ┣ 📂Entity
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Card.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Description.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserAccount.java
    ┃ ┃ ┃ ┃ ┃ ┣ 📂Repository
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CardRepository.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserAccountRepository.java
    ┃ ┃ ┃ ┃ ┃ ┗ 📂Service
    ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CardService.java
    ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserAccountService.java
    ┃ ┃ ┃ ┃ ┗ 📜BrandingHelperApplication.java
    ┣ 📂resources
    ┃ ┣ 📂static
    ┃ ┃ ┗ 📜index.html
    ┃ ┣ 📂templates
    ┃ ┗ 📜application.yml
