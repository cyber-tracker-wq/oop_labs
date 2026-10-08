#!/bin/sh
# Compiles and runs every lab. Needs JDK 17+ (javac on the PATH).
# Usage: ./run-all.sh        (runs everything non-interactively, feeding sample input where needed)
set -e
cd "$(dirname "$0")"

run() { dir=$1; shift; for c in "$@"; do echo "=== $dir / $c"; (cd "$dir" && java "$c"); done; }
for d in lab*; do (cd "$d" && javac *.java); done

run lab01 CarDemo RectangleDemo PersonDemo
run lab02 CircleDemo EmployeeDemo StaticBlocksDemo TemperatureDemo
run lab03 StudentDemo BankDemo ImmutablePersonDemo TemperatureDemo
run lab04 PersonDemo VehicleDemo DogDemo StackDemo
run lab05 PrintDemo AnimalDemo PayrollDemo FieldVsMethodDemo BankPaymentDemo
run lab06 ShapeDemo FlyDemo AccountDemo StudentSortDemo DefaultConflictDemo
echo "=== lab07 / DivideDemo (input: 10 and 2)"; (cd lab07 && printf '10\n2\n' | java DivideDemo)
echo; echo "=== lab07 / DivideDemo (input: abc)";     (cd lab07 && printf 'abc\n'  | java DivideDemo)
echo; echo "=== lab07 / DivideDemo (input: 5 and 0)"; (cd lab07 && printf '5\n0\n' | java DivideDemo)
echo
run lab07 ArrayAccessDemo AgeValidator BankDemo FinallyDemo
run lab08 ListStats RemoveDuplicates MyStackDemo WordFrequency BubbleSortDemo
run lab09 LevelDemo RecordDemo BookSetDemo LinkedListDemo CoinDemo
echo "=== lab10 / FileEchoDemo (sample input)"; (cd lab10 && printf 'one\ntwo\nthree\nfour\nfive\n' | java FileEchoDemo)
run lab10 RemoveEvenDemo FileStats AboveAverageDemo LearnerReport
run lab11 LibraryDemo
echo; echo "Mini-project interactive app:  cd lab11 && java LibraryApp"
