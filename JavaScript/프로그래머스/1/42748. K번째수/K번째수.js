function solution(array, commands) {
  const answer = [];
  for (const command of commands) {
    answer.push(array
      .slice(command[0] - 1, command[1])
      .sort((a, b) => a - b)[command[2] - 1]);
  }
  return answer;
}