<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ランダムお題</title>
<style>

</style>
</head>
<body>
<h2>イラスト練習用お題サイト</h2>
<a href="/theme/Change">登録キャラ確認</a>
<div>

<form id="myForm" action="/theme/Top" method="post">
<p>お題検索<br>
フリーワード検索：<input type="textbox" name="freeword" placeholder="例）眼鏡"><br>
作品タイトル検索：<input type="textbox" name="title" placeholder="例）東方プロジェクト"><br>
<label for=genre>ジャンル：</label>
<input type="radio" name="genre" value="manga">漫画
<input type="radio" name="genre" value="anime">アニメ
<input type="radio" name="genre" value="game">ゲーム
<input type="radio" name="genre" value="other">その他<br>
<label for=sex>性別：</label>
<input type="radio" name="sex" value="1">男
<input type="radio" name="sex" value="2">女
<input type="radio" name="sex" value="3">その他<br>
<br>
<p>追加条件 ※チェックで追加されます</p>
<label for=color>カラー：</label>
<input type="checkbox" id="colorPer"><input type="color" id="color" name="color"><br></p>
<label for="pattern">絵柄：</label>
<input type="checkbox" id="patternPer">
<input type="radio" id="pattern" name="pattern" value="アニメ塗り">アニメ塗り
<input type="radio" id="pattern" name="pattern" value="厚塗り">厚塗り
<input type="radio" id="pattern" name="pattern" value="主線なし">主線なし
<input type="radio" id="pattern" name="pattern" value="デフォルメ">デフォルメ
<input type="radio" id="pattern" name="pattern" value="アナログ風">アナログ風<br></p>
</div>
<input type="submit" value="お題検索">
</form>
</div>
<script type="text/javascript">
  document.getElementById("myForm").addEventListener("submit", function(event) {
    
    const colorPerCheckbox = document.getElementById("colorPer");
    const colorInput = document.getElementById("color");
    
    const patternPerCheckbox = document.getElementById("patternPer");
    const patternInput = document.getElementById("pattern");
    
    if (!colorPerCheckbox.checked) {
    	colorInput.disabled = true;
    }
    
    if (!patternPerCheckbox.checked) {
    	patternInput.disabled = true;
    }
  });
</script>
</body>
</html>