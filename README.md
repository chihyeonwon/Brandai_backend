# Brandai 서비스 백엔드 프로젝트 <a target="_blank" rel="noopener noreferrer nofollow" href="라이센스"><img src="https://camo.githubusercontent.com/624c9e93c3b48d62d41af5687661c2a8a60ce90093685a281cc181bbbe14c6c1/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4c6963656e73652d417061636865322e302d627269676874677265656e" alt="license" data-canonical-src="https://img.shields.io/badge/License-Apache2.0-brightgreen" style="max-width: 100%;"></a> <a target="_blank" rel="noopener noreferrer nofollow" href="ㅁㅁㅁㅁ"><img src="https://img.shields.io/badge/Release-1.0.0-ec8034" alt="license" data-canonical-src="https://img.shields.io/badge/Release-1.0.0-ec8034" style="max-width: 100%;"></a>
## 1. 소개


> 디지털 격차를 해소할 수 있는 서비스

디지털 사회가 급격히 발전함에 따라 정보의 격차가 발생하고 있다. 특히 농어촌 주민이나 . ~~


<br>

## 2. 사용 방법 
## 3. API 명세서
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
    ┃ ┃ ┃ ┃ ┃ ┗ 📜SwaggerConfig.java
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