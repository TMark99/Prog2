#include <iostream>

using namespace std;
class Madar{
	public:
		void repul(char nev[]){
		cout<<nev<<" repul\n";
			}
};

class Golya : public Madar
{
	public:	
	char nev[7]="Golya";
};
class Sas : public Madar
{
	public:
	char nev[4]="Sas";
};
class Pingvin : public Madar
{
	public:
	char nev[8]="Pingvin";
};
int main()
{
	Golya golya;
	Sas sas;
	Pingvin pingvin;
	golya.repul(golya.nev);	
	sas.repul(sas.nev);
	pingvin.repul(pingvin.nev);		
	return 0;
}
