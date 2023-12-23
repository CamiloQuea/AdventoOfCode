package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"slices"
	"strconv"
)

func main() {

	textArray := readFile()

	totalCaloriesElfs := make([]int, 0)
	var actualElf int

	for _, line := range textArray {

		if line == "" {
			totalCaloriesElfs = append(totalCaloriesElfs, actualElf)
			actualElf = 0
			continue
		}

		calories, err := strconv.ParseInt(line, 10, 64)

		if err != nil {

			log.Fatalln("ERROR, NO NUMBER!!! : ", line)

		}

		actualElf += int(calories)

	}

	slices.Sort(totalCaloriesElfs)
	slices.Reverse(totalCaloriesElfs)

	fmt.Println(totalCaloriesElfs[0] + totalCaloriesElfs[1] + totalCaloriesElfs[2])

}

func readFile() []string {
	file, err := os.Open("1/input.txt")

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
