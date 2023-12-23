package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

const (
	ROCK_POINTS     = 1
	PAPER_POINTS    = 2
	SCISSORS_POINTS = 3
	WIN_POINTS      = 6
	DRAW_POINTS     = 3
	LOSS_POINTS     = 0

	VALUE = 0
	WIN   = 1
	LOSS  = 2
)

var (
	ROCK     = [2]string{"A", "X"}
	PAPER    = [2]string{"B", "Y"}
	SCISSORS = [2]string{"C", "Z"}
)

func main() {

	games := readFile()

	totalPoints := 0

	for _, game := range games {

		game := strings.Split(game, " ")

		// oponnentPlay := game[0]
		myPlay := game[1]
		// win := checkPlay(myPlay, oponnentPlay)

		playPoints := getScoreByPlay(myPlay)

		// fmt.Println(myPlay, " vs ", oponnentPlay, win)
		fmt.Println("play point: ", playPoints)
		if myPlay == "Y" {
			totalPoints += DRAW_POINTS + playPoints
			fmt.Println("total points: ", totalPoints)
			fmt.Println("DRAW")
			continue
		} else if myPlay == "Z" {
			totalPoints += WIN_POINTS + playPoints
			fmt.Println("total points: ", totalPoints)
			fmt.Println("WIN")
			continue
		}
		totalPoints += playPoints + LOSS_POINTS
		fmt.Println("total points: ", totalPoints)
		fmt.Println("LOST")

	}

	fmt.Println(totalPoints)
}

func checkPlay(me string, oponnent string) *bool {

	if me == ROCK[1] && oponnent == ROCK[0] ||
		me == PAPER[1] && oponnent == PAPER[0] ||
		me == SCISSORS[1] && oponnent == SCISSORS[0] {
		return nil
	}

	defaultValue := true
	result := &defaultValue
	*result = true

	if me == ROCK[1] && oponnent == SCISSORS[0] {
		return result
	}

	if me == PAPER[1] && oponnent == ROCK[0] {
		return result
	}

	if me == SCISSORS[1] && oponnent == PAPER[0] {
		return result
	}

	*result = false

	return result

}

func getScoreByPlay(me string) int {
	switch me {
	case ROCK[1]:
		return ROCK_POINTS
	case PAPER[1]:
		return PAPER_POINTS
	case SCISSORS[1]:
		return SCISSORS_POINTS

	}
	return 0
}

func readFile() []string {
	file, err := os.Open("2/input2.txt")

	if err != nil {
		fmt.Println(err)
	}

	defer file.Close()

	fileScanner := bufio.NewScanner(file)

	fileScanner.Split(bufio.ScanLines)

	var fileLines []string

	for fileScanner.Scan() {

		fileLines = append(fileLines, fileScanner.Text())

	}

	return fileLines

}
