# Cursor에서 실행하기 🚀

이 프로젝트는 Cursor IDE에서 쉽게 실행할 수 있도록 설정되었습니다.

## 📋 필수 확장 프로그램

Cursor에 다음 확장 프로그램을 설치하세요:

1. **Extension Pack for Java** (Microsoft)
   - Language Support for Java
   - Debugger for Java
   - Maven for Java
   - Test Runner for Java

2. **Spring Boot Extension Pack** (VMware)
   - Spring Boot Tools
   - Spring Boot Dashboard

## 🚀 실행 방법

### 방법 1: F5 키로 실행 (가장 쉬움!)

1. `F5` 키를 누르거나
2. 메뉴: `Run` > `Start Debugging`
3. 또는 왼쪽 사이드바에서 `Run and Debug` (▶️) 아이콘 클릭 후 `Spring Boot App` 선택

### 방법 2: 터미널에서 실행

#### 통합 터미널 열기
- `` Ctrl + ` `` (백틱) 키 또는
- 메뉴: `Terminal` > `New Terminal`

#### 실행 명령어
```bash
# 직접 실행
.\mvnw.cmd spring-boot:run

# 또는 실행 스크립트 사용
.\run.cmd
```

### 방법 3: Tasks 사용

1. `Ctrl + Shift + P` 눌러서 Command Palette 열기
2. `Tasks: Run Task` 입력
3. `Spring Boot: Run` 선택

## 🔨 빌드 방법

### Command Palette에서
1. `Ctrl + Shift + P`
2. `Tasks: Run Build Task` 또는 `Ctrl + Shift + B`
3. `Maven: Package` 선택

### 터미널에서
```bash
# 빌드만 (테스트 제외)
.\mvnw.cmd clean package -DskipTests

# 또는 빌드 스크립트 사용
.\build.cmd
```

## 🐛 디버깅

1. 코드에 중단점(Breakpoint) 설정: 줄 번호 왼쪽 클릭
2. `F5` 키로 디버그 모드 실행
3. 변수 값 확인, 스텝 실행 등 가능

## 📱 실행 후 접속 URL

| 항목 | URL |
|------|-----|
| 메인 | http://localhost:8090 |
| Swagger UI | http://localhost:8090/swagger-ui.html |
| API Docs | http://localhost:8090/v3/api-docs |
| Health Check | http://localhost:8090/actuator/health |
| Prometheus | http://localhost:8090/actuator/prometheus |

## 🎯 유용한 단축키

| 기능 | Windows |
|------|---------|
| 실행/디버그 | `F5` |
| 빌드 | `Ctrl + Shift + B` |
| 터미널 열기 | ``Ctrl + ` `` |
| 명령 팔레트 | `Ctrl + Shift + P` |
| 파일 검색 | `Ctrl + P` |
| 전체 검색 | `Ctrl + Shift + F` |

## 📦 프로젝트 구조

```
MySpringBoot/
├── .vscode/              # Cursor/VSCode 설정
│   ├── launch.json      # 실행 설정
│   ├── tasks.json       # 빌드 작업 설정
│   └── settings.json    # 프로젝트 설정
├── docs/                # 문서 폴더 (모든 .md 파일)
├── src/
│   ├── main/
│   │   ├── java/        # Java 소스 코드
│   │   └── resources/   # 설정 파일
│   └── test/            # 테스트 코드
├── pom.xml              # Maven 설정
├── run.cmd              # 실행 스크립트
└── build.cmd            # 빌드 스크립트
```

## ⚠️ 문제 해결

### Java 확장이 활성화되지 않는 경우
1. `Ctrl + Shift + P`
2. `Java: Clean Java Language Server Workspace` 실행
3. Cursor 재시작

### 프로젝트가 인식되지 않는 경우
1. `pom.xml` 파일 열기
2. 우클릭 > `Update Project Configuration`

### 데이터베이스 연결 오류
- `application.properties` 파일에서 DB 설정 확인
- MySQL 서버 접근 가능 여부 확인

## 💡 팁

- **Hot Reload**: Spring Boot DevTools가 있으면 코드 수정 시 자동 재시작
- **로그 확인**: 통합 터미널에서 실시간으로 로그 확인 가능
- **Swagger**: http://localhost:8090/swagger-ui.html 에서 API 테스트

---

즐거운 개발 되세요! 🎉
