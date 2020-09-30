#include <iostream>

using namespace std;

class Szulo{
	public: void ir(){cout<<"szulo";}
}; 

class gyerek : public Szulo
{
	public: void kiir(){
		cout<<"Gyerek";
}
};


int main()
{
	Szulo apa;
	gyerek fia;
	apa.ir();
	fia.ir();
	fia.kiir();
	//apa.kiir();
	return 0;
}
