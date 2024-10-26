#include <cstdio>
#include <iostream>
#include <memory>
#include <stdexcept>
#include <string>
#include <array>

using namespace std;

void bees()
{
	int total = 0, total1 = 0, total2 = 1, gen;
	cout << "Enter the generation: " << endl;
	cin >> gen;
	for(int i = 0; i < gen; i++) {
		total = total1 + total2;
		total1 = total2;
		total2 = total;
	}
	cout << "The amount of bees in " << gen << " generation(s) is " << total << " bees(s)." << endl;
}
/*
string exec(const char* cmd)
{
    array<char, 128> buffer;
    string result;
    unique_ptr<FILE, decltype(&pclose)> pipe(popen(cmd, "r"), pclose);
    if (!pipe)
    {
        throw runtime_error("popen() failed!");
    }
    while (fgets(buffer.data(), buffer.size(), pipe.get()) != nullptr)
    {
        result += buffer.data();
    }
    return result;
}
*/
int main()
{
	//bees();
}
