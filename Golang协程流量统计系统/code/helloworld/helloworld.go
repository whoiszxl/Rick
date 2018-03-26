package main

import "fmt"

func main() {
	message := make(chan string)
	//go 关键字声明了一个协程,通过messagse的channel将信息传递到print中
	go func() {
		message <- "hello child"
	}()
	fmt.Print("hello man")
	fmt.Print( <-message )
}