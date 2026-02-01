# 프로젝트 파일 구조 가이드 📁

## 📂 루트 디렉토리 파일 설명

### 필수 파일 (삭제 금지 🚫)

| 파일/폴더 | 용도 | 설명 |
|-----------|------|------|
| `pom.xml` | Maven 설정 | 프로젝트 의존성 및 빌드 설정 |
| `mvnw` | Maven Wrapper (Unix) | Maven 없이도 빌드 가능 |
| `mvnw.cmd` | Maven Wrapper (Windows) | Maven 없이도 빌드 가능 |
| `.mvn/` | Maven Wrapper 설정 | Maven Wrapper 실행에 필요 |
| `src/` | 소스 코드 | Java 코드 및 리소스 파일 |
| `.gitignore` | Git 제외 설정 | 커밋하지 않을 파일 지정 |

### 편의 스크립트 (있으면 좋음 ✅)

| 파일 | 용도 | 설명 |
|------|------|------|
| `run.cmd` | 빠른 실행 | 애플리케이션 실행 스크립트 |
| `build.cmd` | 빠른 빌드 | 빌드 스크립트 |

### 문서 및 설정 (팀 협업용 📚)

| 파일/폴더 | 용도 | 설명 |
|-----------|------|------|
| `readme.md` | 프로젝트 소개 | 프로젝트 빠른 시작 가이드 |
| `docs/` | 상세 문서 | 모든 마크다운 문서 (소문자 .md) |
| `.vscode/` | Cursor/VSCode 설정 | 디버그, 빌드 설정 (팀 공유) |

### Git이 무시하는 파일/폴더 (자동 생성 🔄)

| 파일/폴더 | 생성 시점 | 용도 |
|-----------|-----------|------|
| `target/` | 빌드 시 | 컴파일된 클래스 및 JAR 파일 |
| `logs/` | 실행 시 | 애플리케이션 로그 파일 |
| `*.log` | 실행/에러 시 | 각종 로그 파일 |
| `.idea/` | IntelliJ 사용 시 | IntelliJ 설정 |
| `*.iml` | IntelliJ 사용 시 | IntelliJ 모듈 파일 |

---

## 🗂️ 상세 디렉토리 구조

```
MySpringBoot/
│
├── 📝 설정 파일
│   ├── pom.xml                      # Maven 프로젝트 설정
│   ├── .gitignore                   # Git 제외 파일 설정
│   ├── .cursorrules                 # Cursor AI 규칙
│   └── .mvn/                        # Maven Wrapper 설정
│       ├── jvm.config               # JVM 옵션
│       └── wrapper/
│           ├── maven-wrapper.jar
│           └── maven-wrapper.properties
│
├── 🚀 실행 스크립트
│   ├── mvnw, mvnw.cmd              # Maven Wrapper 실행 스크립트
│   ├── run.cmd                     # 빠른 실행
│   └── build.cmd                   # 빠른 빌드
│
├── 📚 문서 (모두 소문자 .md)
│   ├── readme.md                   # 프로젝트 빠른 시작
│   └── docs/                       # 상세 문서 폴더
│       ├── readme.md               # 문서 목록 및 프로젝트 개요
│       ├── run-in-cursor.md        # Cursor 실행 가이드
│       └── project-structure.md    # 이 파일 - 구조 가이드
│
├── ⚙️ IDE 설정
│   └── .vscode/                    # Cursor/VSCode 설정
│       ├── launch.json             # 디버그 설정 (F5 실행)
│       ├── tasks.json              # 빌드 태스크
│       └── settings.json           # 에디터 설정
│
├── 💻 소스 코드
│   └── src/
│       ├── main/
│       │   ├── java/               # Java 소스 코드
│       │   │   └── kr/wonil/myspringboot/
│       │   │       ├── MySpringBootApplication.java  # 메인 클래스
│       │   │       ├── config/                       # 설정 클래스
│       │   │       ├── myexpense/                    # 지출 관리
│       │   │       ├── myinvest/                     # 투자 관리
│       │   │       ├── mymanage/                     # 메모 관리
│       │   │       ├── sms/                          # SMS 관리
│       │   │       ├── yahoofinance/                 # 야후 금융
│       │   │       ├── Crawler/                      # 크롤러
│       │   │       ├── scheduler/                    # 스케줄러
│       │   │       └── util/                         # 유틸리티
│       │   └── resources/
│       │       ├── application.properties            # 설정 파일
│       │       └── logback-spring.xml               # 로그 설정
│       └── test/                   # 테스트 코드
│
└── 🗑️ Git 무시 (자동 생성)
    ├── target/                     # 빌드 출력
    ├── logs/                       # 로그 파일
    ├── *.log                       # 로그 파일
    └── .idea/                      # IntelliJ 설정
```

---

## ⚠️ 주의사항

### 절대 삭제하면 안 되는 것

1. **`pom.xml`** - 프로젝트가 작동하지 않음
2. **`mvnw`, `mvnw.cmd`, `.mvn/`** - Maven Wrapper, 삭제 시 빌드 불가
3. **`src/`** - 소스 코드, 삭제 시 프로젝트 사라짐
4. **`.gitignore`** - 중요한 보안 설정

### 삭제해도 되는 것 (재생성 가능)

1. **`target/`** - 빌드하면 다시 생성됨
2. **`logs/`** - 실행하면 다시 생성됨
3. **`*.log`** - 로그 파일, 실행 중 재생성
4. **`.idea/`, `*.iml`** - IntelliJ가 다시 생성

### 선택적 파일

1. **`run.cmd`, `build.cmd`** - 편의 스크립트, 없어도 `mvnw.cmd` 사용 가능
2. **`.vscode/`** - Cursor/VSCode 사용자만 필요
3. **`docs/`** - 문서, 없어도 프로젝트 실행은 가능

---

## 🔍 파일 역할 상세 설명

### Maven Wrapper란?

Maven이 시스템에 설치되지 않아도 프로젝트를 빌드할 수 있게 해주는 도구입니다.

- **장점**: 팀원마다 다른 Maven 버전 사용 문제 해결
- **파일**: `mvnw`, `mvnw.cmd`, `.mvn/`
- **사용법**: `.\mvnw.cmd clean package`

### 루트에 스크립트 파일이 있는 이유

**`run.cmd`**, **`build.cmd`**

- ✅ **빠른 접근**: 프로젝트 루트에서 바로 더블클릭 실행 가능
- ✅ **명확한 의도**: 파일명만 봐도 용도 명확
- ✅ **초보자 친화적**: 복잡한 명령어 몰라도 실행 가능
- ✅ **표준 관행**: 많은 프로젝트가 루트에 편의 스크립트 배치

### 문서 파일 명명 규칙

**모든 마크다운 파일은 소문자로 작성합니다:**

- ✅ `readme.md` (올바름)
- ✅ `run-in-cursor.md` (올바름)
- ✅ `project-structure.md` (올바름)
- ❌ `README.md` (사용 금지)
- ❌ `RUN_IN_CURSOR.md` (사용 금지)

**이유:**
- 대소문자 구분이 다른 OS 간 호환성
- URL 생성 시 일관성
- 검색 및 참조 시 명확성

### 문서 파일 위치 규칙

**모든 마크다운 문서는 `docs/` 폴더에 저장합니다:**

- ✅ `docs/readme.md`
- ✅ `docs/run-in-cursor.md`
- ✅ `docs/project-structure.md`
- ⚠️ 루트의 `readme.md`는 예외 (프로젝트 진입점)

---

## 📊 .gitignore 설정 요약

### 무시되는 파일/폴더

```
✓ logs/              # 로그 폴더
✓ *.log              # 모든 로그 파일
✓ target/            # 빌드 출력
✓ .idea/             # IntelliJ 설정
✓ *.iml              # IntelliJ 모듈
✓ .DS_Store          # macOS 메타데이터
✓ Thumbs.db          # Windows 메타데이터
✓ *.env              # 환경 변수 파일
✓ credentials.json   # 인증 정보
```

### Git에 포함되는 파일

```
✓ pom.xml            # Maven 설정
✓ mvnw, mvnw.cmd     # Maven Wrapper
✓ .mvn/              # Wrapper 설정
✓ src/               # 소스 코드
✓ .vscode/           # VSCode 설정 (팀 공유)
✓ docs/              # 문서 (소문자 .md 파일들)
✓ run.cmd            # 실행 스크립트
✓ build.cmd          # 빌드 스크립트
✓ readme.md          # 프로젝트 문서
```

---

## 🎯 베스트 프랙티스

### 1. 빌드 전 정리

```bash
# target 폴더 삭제 후 새로 빌드
.\mvnw.cmd clean package
```

### 2. 로그 관리

로그 파일은 자동으로 관리되며 Git에 포함되지 않습니다.
필요시 수동으로 `logs/` 폴더 정리 가능합니다.

### 3. 새 파일 추가 시

프로젝트에 새 파일을 추가할 때:
- 📝 **문서 (.md)**: 반드시 `docs/` 폴더에 소문자로 추가
- 🔧 **스크립트**: 루트에 `.cmd` 파일로 추가
- 💾 **설정**: `.vscode/` 또는 루트에 추가

### 4. Git 커밋 전 확인

```bash
# 어떤 파일이 커밋될지 확인
git status

# .gitignore가 제대로 작동하는지 확인
git status --ignored
```

---

## ❓ FAQ

**Q: `target/` 폴더가 너무 큽니다. 삭제해도 되나요?**  
A: 네, 안전하게 삭제 가능합니다. 다음 빌드 시 다시 생성됩니다.

**Q: `.mvn/` 폴더는 무엇인가요?**  
A: Maven Wrapper 설정 폴더입니다. 삭제하면 안 됩니다.

**Q: `run.cmd`를 삭제하면 어떻게 되나요?**  
A: 삭제해도 됩니다. 대신 `.\mvnw.cmd spring-boot:run`으로 실행하면 됩니다.

**Q: IntelliJ에서 열었더니 `.idea/` 폴더가 생겼어요.**  
A: 정상입니다. `.gitignore`에 의해 Git에는 포함되지 않습니다.

**Q: 로그 파일이 계속 쌓입니다.**  
A: `logs/` 폴더는 Git에 포함되지 않으므로 수동으로 정리해도 됩니다.

**Q: 마크다운 파일을 대문자로 만들어도 되나요?**  
A: 아니요. 반드시 소문자로 작성하고 `docs/` 폴더에 저장해야 합니다.

---

**마지막 업데이트**: 2026-02-01
