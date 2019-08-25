## git 명령어 정리

#### gli clone
git clone <git repository URL> <directory 명> : 개발 리파지토리를 로컬의 directory에 클론한다. <br>
```$xslt
git clone https://github.com/isisrin/git-study project
``` 

#### git branch
git branch -a : 브랜치의 상태를 확인할 수 있다. -a를 붙이지 않으면 로컬의 상태만 확인한다 <br>
```$xslt
~/project (master)$ git branch -a

* master
  remotes/origin/develop
  remotes/origin/master
```
리모트 브랜치로 develop와 master가 있는 것을 확인할 수 있다. <br>
git branch -d <삭제할 브랜치명> : git branch -d 명령어로 로컬 브랜치를 삭제할 수 있다.
```$xslt
~/project (develop)$ git branch -d feature/five-to-ten
```

#### git checkout
git checkout -b <새로 작성할 로컬 브랜치명> <복사할 리모트 브랜치명> : 복사할 리모트 브랜치를 복사해서 로컬 브랜치에 복사함
```$xslt
~/project (master)$ git checkout -b feature/five-to-ten remotes/origin/develop
```
작성한 후에 git branch 명령어를 실행시키면 브랜치가 생긴 것을 확인할 수 있음
```$xslt
~/project (feature/five-to-ten)$ git branch

* feature/five-to-ten
  master
```

#### git diff
git diff <수정된 것 확인할 파일명> : 수정 사항이 라인단위로 나옴
git diff --cached <수정된 것 확인할 파일명> : 인덱스 파일의 수정내역을 확인 함 (커밋 하기전 최종 확인)

#### git add 
git add <인덱스로 이동시킬 파일 명> : git add 명령어로 수정한 파일을 워크트리에서 인덱스로 이동시킴.

#### git status
git status : 인덱스 상태를 확인함.

#### git commit
git commit -m <커밋메세지> : 인덱스 파일을 브랜치에 반영
git commit --amend : 하나 앞의 커밋을 포함한다

#### git log
git log : 브랜치 로그 확인 <br>
git log --online : 간략하게 한줄 내역 확인

#### git push
git push <리모트명> <브랜치명> : 리모트 브랜치에 반영시킴 <br>
git push -d <리모트명> <삭제할 브랜치명> : git push -d 명령어로 리모트 브랜치도 삭제할 수 있다

#### git merge
git merge <머지할 브랜치명> : git merge 명령어로 개발 브랜치를 머지할 브랜치에 반영함
```$xslt
~/project (feature/five-to-ten)$ git checkout develop  # develop 브랜치로 이동
~/project (develop)$ git merge feature/five-to-ten     # develop 브랜치에 five-to-ten을 머지함
~/project (develop)$ git push origin develop           # develop 브랜치에 푸시함
```

#### git fetch
git fetch -p : 로컬에 저장중인 리모트 브랜치 정보를 최신으로 갱신한다 <br>
`참고 : git clone한 직후는 이미 최신상태 이므로 git fetch 하지 않아도 됨`

#### git stash
git stash save -u <메세지> : 수정사항을 잠시 저장해 둔다 <br>
git stash list : 잠시 중단해 놨던 개발내역 리스트를 볼 수 있다 <br>
git stash pop <stash 번호> : 수정하던 코드를 불러온다

#### git rebase 
git rebase <브랜치명> : git rebase 명령어로 이력을 깨끗하게 만듦. (push가 가능해짐)
git rebase --continue : 충돌을 해결한 파일을 add하고 나서 `git rebase --continue` 명령어로 rebase를 끝낸다
git rebase -i : 2개 이상 앞의 커밋을 정리할 때 사용

출처 : [https://qiita.com/west-hiroaki/items/74cccbc22b2cc7a4aacb?utm_source=Qiita%E3%83%8B%E3%83%A5%E3%83%BC%E3%82%B9&utm_campaign=5754d6b205-Qiita_newsletter_368_07_03_2019&utm_medium=email&utm_term=0_e44feaa081-5754d6b205-33558493]

