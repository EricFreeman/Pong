Global song = PlayMusic("sfx/DemoSong.mp3")
Graphics 800,600,32
AppTitle"Pong: Attack of the Evil Killer Death Paddles!"
SetBuffer BackBuffer()

main = LoadImage("gfx/main.png")

DrawImage main,0,0
Flip
FlushKeys()
WaitKey
Cls

story = LoadImage("gfx/story.png")

DrawImage story,0,0
Flip
FlushKeys()
WaitKey
Cls

screen1 = LoadImage("gfx/screen1.png")
talk1 = LoadImage("gfx/talk1.png")

DrawImage screen1,0,0
DrawImage talk1,0,0
Flip
FlushKeys()
WaitKey
Cls

lev1screen = LoadImage("gfx/lev1-screen.png")

DrawImage lev1screen,0,0
Flip
FlushKeys()
WaitKey

lev1 = LoadImage("gfx/lev1-back.png")
Global p1image = LoadImage("gfx/paddle1.png")
Global p2image = LoadImage("gfx/paddle2.png")
Global ballimage = LoadImage("gfx/ball.png")
Global paddle = LoadSound("sfx/paddle.wav")
Global wall = LoadSound("sfx/wall.wav")

Type ball
	Field x,y,dx,dy
End Type

Type p1
	Field x,y
End Type

Type p2
	Field x,y
End Type

p1.p1 = New p1

p2.p2 = New p2

ball.ball = New ball

p1\x = 35
p2\x = 740
p2\y = 250
speedx# = 2
speedy# = 2

MoveMouse 400,250
HidePointer

While Not KeyDown(2)
Cls

If KeyHit(1) Then End

If (ImagesCollide(p1image,p1\x,p1\y,0,ballimage,ball\x,ball\y,0))
	ball\dx = 0
	arg = p1\y
	arg = arg - 50
	If ball\y > p1\y + 50
		ball\dy = 0
	EndIf
	If ball\y < p1\y + 50
		ball\dy = 1
	EndIf
	PlaySound paddle
EndIf

If (ImagesCollide(p2image,p2\x,p2\y,0,ballimage,ball\x,ball\y,0))
	ball\dx = 1
	If ball\y > p2\y + 50
		ball\dy = 0
	EndIf
	If ball\y < p2\y + 50
		ball\dy = 1
	EndIf
	PlaySound paddle
EndIf

If ball\x < 0 Then Goto lose

ball\y = ball\y - 50

If ball\y > p2\Y
	p2\y = p2\y + 2
EndIf

If ball\y < p2\Y
	p2\y = p2\y - 2
EndIf

ball\y = ball\y + 50

If hit = 0 
	ball\x = p1\x + 45
	ball\y = p1\y + 40
EndIf

If MouseHit(1) Then hit = 1

If hit = 1
	If ball\dx = 0 Then ball\x = ball\x + speedx#
	If ball\dx = 1 Then ball\x = ball\x - speedx#
	If ball\dy = 0 Then ball\y = ball\y + speedy#
	If ball\dy = 1 Then ball\y = ball\y - speedy#
EndIf

If ball\y > 570 
	PlaySound wall
	If ball\dy = 0 
		ball\dy = 1
		SeedRnd MilliSecs()
		sup = Rand(1,3)
		If sup = 2 Then speedx# = speedx# + 1
		If sup = 1 Then speedy# = speedy# + 1
		Goto thing
	EndIf
	If ball\dy = 1 Then ball\dy = 0
EndIf

If ball\y < 10 
	If ball\dy = 0 
		ball\dy = 1
		SeedRnd MilliSecs()
		sup2 = Rand(1,3)
		If sup2 = 2 Then speedx# = speedx# + 1
		If sup2 = 1 Then speedy# = speedy# + 1
		Goto thing
	EndIf
	If ball\dy = 1 Then ball\dy = 0
	PlaySound wall
EndIf

If ball\x > 800
	Goto lev2s
EndIf

.thing

p1\y = MouseY()

DrawImage lev1,0,0
DrawImage p1image,p1\x,p1\y
DrawImage p2image,p2\x,p2\y
DrawImage ballimage,ball\x,ball\y

Flip
Wend

.lev2s
lev1win = LoadImage("gfx/talk2.png")
lev1win2 = LoadImage("gfx/screen1.png")

DrawImage lev1win,0,0
DrawImage lev1win2,0,0
Flip
FlushKeys()
WaitKey
Cls

lev2screen = LoadImage("gfx/lev2-screen.png")

DrawImage lev2screen,0,0
Flip

WaitKey























Graphics 800,600,32
AppTitle"Pong: Attack of the Evil Killer Death Paddles!"
SetBuffer BackBuffer()

Global lev2 = LoadImage("gfx/lev2-back.png")
Global p11image = LoadImage("gfx/paddle1.png")
Global p21image = LoadImage("gfx/paddle2.png")
Global ball1image = LoadImage("gfx/ball.png")
Global paddle1 = LoadSound("sfx/paddle.wav")
Global wall1 = LoadSound("sfx/wall.wav")

Type ball1
	Field x,y,dx,dy
End Type

Type p11
	Field x,y
End Type

Type p21
	Field x,y
End Type

p11.p11 = New p11

p21.p21 = New p21

ball1.ball1 = New ball1

p11\x = 35
p21\x = 740
p21\y = 250
speedx# = 2
speedy# = 2

MoveMouse 400,250
HidePointer

While Not KeyDown(2)
Cls

If ChannelPlaying(song) = False Then song = PlayMusic("sfx/DemoSong.mp3")

If ball1\x < 0 Then Goto lose

If KeyHit(1) Then End

If (ImagesCollide(p11image,p11\x,p11\y,0,ball1image,ball1\x,ball1\y,0))
	ball1\dx = 0
	If ball1\y > p11\y + 50
		ball1\dy = 0
	EndIf
	If ball1\y < p11\y + 50
		ball1\dy = 1
	EndIf
	PlaySound paddle1
EndIf

If (ImagesCollide(p21image,p21\x,p21\y,0,ball1image,ball1\x,ball1\y,0))
	ball1\dx = 1
	If ball1\y > p21\y + 50
		ball1\dy = 0
	EndIf
	If ball1\y < p21\y + 50
		ball1\dy = 1
	EndIf
	PlaySound paddle1
EndIf

ball1\y = ball1\y - 50

If ball1\y > p21\Y
	p21\y = p21\y + 3
EndIf

If ball1\y < p21\Y
	p21\y = p21\y - 3
EndIf

ball1\y = ball1\y + 50

If hit = 1
	ball1\x = p11\x + 45
	ball1\y = p11\y + 40
EndIf

If MouseHit(1) And hit = 1 Then hit = 2

If hit = 2
	If ball1\dx = 0 Then ball1\x = ball1\x + speedx#
	If ball1\dx = 1 Then ball1\x = ball1\x - speedx#
	If ball1\dy = 0 Then ball1\y = ball1\y + speedy#
	If ball1\dy = 1 Then ball1\y = ball1\y - speedy#
EndIf

If ball1\y > 580 
	PlaySound wall1
	If ball1\dy = 0 
		ball1\dy = 1
		SeedRnd MilliSecs()
		sup11 = Rand(1,3)
		If sup11 = 2 Then speedx# = speedx# + 1
		If sup11 = 1 Then speedy# = speedy# + 1
		Goto thinger
	EndIf
	If ball1\dy = 1 Then ball1\dy = 0
EndIf

If ball1\y < 10 
	If ball1\dy = 0 
		ball1\dy = 1
		SeedRnd MilliSecs()
		sup211 = Rand(1,3)
		If sup211 = 2 Then speedx# = speedx# + 1
		If sup211 = 1 Then speedy# = speedy# + 1
		Goto thinger
	EndIf
	If ball1\dy = 1 Then ball1\dy = 0
	PlaySound wall1
EndIf

If ball1\x > 800
	Goto lev3s
EndIf

.thinger

p11\y = MouseY()

DrawImage lev2,0,0
DrawImage p11image,p11\x,p11\y
DrawImage p21image,p21\x,p21\y
DrawImage ball1image,ball1\x,ball1\y

Flip
Wend


.lev3s
screen1 = LoadImage("gfx/screen1.png")
talk4 = LoadImage("gfx/talk4.png")

DrawImage screen1,0,0
DrawImage talk4,0,0
Flip

WaitKey
Cls

lev3screen = LoadImage("gfx/lev3-screen.png")

DrawImage lev3screen,0,0
Flip
FlushKeys()
WaitKey
Cls































Graphics 800,600,32
AppTitle"Pong: Attack of the Evil Killer Death Paddles!"
SetBuffer BackBuffer()

Global lev3 = LoadImage("gfx/lev3-back.png")
Global p112image = LoadImage("gfx/paddle1.png")
Global p212image = LoadImage("gfx/paddle2.png")
Global ball12image = LoadImage("gfx/ball.png")
Global paddle2 = LoadSound("sfx/paddle.wav")
Global wall2 = LoadSound("sfx/wall.wav")

Type ball12
	Field x,y,dx,dy
End Type

Type p112
	Field x,y
End Type

Type p212
	Field x,y
End Type

p112.p112 = New p112

p212.p212 = New p212

ball12.ball12 = New ball12

p112\x = 35
p212\x = 740
p212\y = 250
speedx2# = 2
speedy2# = 2
hit2 = 0

MoveMouse 400,250
HidePointer

While Not KeyDown(2)
Cls

If ChannelPlaying(song) = False Then song = PlayMusic("sfx/DemoSong.mp3")

If ball12\x < 0 Then Goto lose

If KeyHit(1) Then End

If (ImagesCollide(p112image,p112\x,p112\y,0,ball12image,ball12\x,ball12\y,0))
	ball12\dx = 0
	If ball12\y > p112\y + 50
		ball12\dy = 0
	EndIf
	If ball12\y < p112\y + 50
		ball12\dy = 1
	EndIf
	PlaySound paddle2
EndIf

If (ImagesCollide(p212image,p212\x,p212\y,0,ball12image,ball12\x,ball12\y,0))
	ball12\dx = 1
	If ball12\y > p212\y + 50
		ball12\dy = 0
	EndIf
	If ball12\y < p212\y + 50
		ball12\dy = 1
	EndIf
	PlaySound paddle2
EndIf

ball12\y = ball12\y - 50

If ball12\y > p212\Y
	p212\y = p212\y + 3
EndIf

If ball12\y < p212\Y
	p212\y = p212\y - 3
EndIf

ball12\y = ball12\y + 50

If hit2 = 0
	ball12\x = p112\x + 45
	ball12\y = p112\y + 40
EndIf

If MouseHit(1) And hit2 = 0 Then hit2 = 1

If hit2 = 1
	If ball12\dx = 0 Then ball12\x = ball12\x + speedx2#
	If ball12\dx = 1 Then ball12\x = ball12\x - speedx2#
	If ball12\dy = 0 Then ball12\y = ball12\y + speedy2#
	If ball12\dy = 1 Then ball12\y = ball12\y - speedy2#
EndIf

If ball12\y > 580 
	PlaySound wall2
	If ball12\dy = 0 
		ball12\dy = 1
		SeedRnd MilliSecs()
		sup112 = Rand(1,3)
		If sup112 = 2 Then speedx2# = speedx2# + 1
		If sup112 = 1 Then speedy2# = speedy2# + 1
		Goto thingers
	EndIf
	If ball12\dy = 1 Then ball12\dy = 0
EndIf

If ball12\y < 10 
	If ball12\dy = 0 
		ball12\dy = 1
		SeedRnd MilliSecs()
		sup2112 = Rand(1,3)
		If sup2112 = 2 Then speedx2# = speedx2# + 1
		If sup2112 = 1 Then speedy2# = speedy2# + 1
		Goto thingers
	EndIf
	If ball12\dy = 1 Then ball12\dy = 0
	PlaySound wall2
EndIf

If ball12\x > 800
	Goto lev4s
EndIf

.thingers

p112\y = MouseY()

DrawImage lev3,0,0
DrawImage p112image,p112\x,p112\y
DrawImage p212image,p212\x,p212\y
DrawImage ball12image,ball12\x,ball12\y

Flip
Wend










.lev4s
lev4win = LoadImage("gfx/talk5.png")
lev4win2 = LoadImage("gfx/screen1.png")

DrawImage lev4win,0,0
DrawImage lev4win2,0,0
Flip
FlushKeys()
WaitKey
Cls
End







































































.lose
Graphics 800,600,32
AppTitle"Pong: Attack of the Evil Killer Death Paddles!"
SetBuffer BackBuffer()

screen1 = LoadImage("gfx/screen1.png")
talk3 = LoadImage("gfx/talk3.png")

DrawImage screen1,0,0
DrawImage talk3,0,0
Flip
FlushKeys()
WaitKey
Cls



















































