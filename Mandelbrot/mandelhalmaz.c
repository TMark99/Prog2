#include <stdio.h>
#include <stdlib.h>
#include <png.h>
#include <sys/times.h>
#include <libpng16/png.h>

#define SIZE 600
#define ITERATION_LIMIT 32000

void mandel (int buffer[SIZE][SIZE]) {

    clock_t delta = clock ();
    struct tms tmsbuf1, tmsbuf2;
    times (&tmsbuf1);

    float a = -2.0, b = .7, c = -1.35, d = 1.35;
    int width = SIZE, height = SIZE, iterationLimit = ITERATION_LIMIT;

    float dx = (b - a) / width;
    float dy = (d - c) / height;
    float reC, imC, reZ, imZ, newReZ, newImZ;

    int iteration = 0;
    
    for (int j = 0; j < height; ++j)
    {
        for (int k = 0; k < width; ++k)
        {
            
            reC = a + k * dx;
            imC = d - j * dy;
            
            reZ = 0;
            imZ = 0;
            iteration = 0;
            
            while (reZ * reZ + imZ * imZ < 4 && iteration < iterationLimit)
            {
                newReZ = reZ * reZ - imZ * imZ + reC;
                newImZ = 2 * reZ * imZ + imC;
                reZ = newReZ;
                imZ = newImZ;

                ++iteration;

            }

            buffer[j][k] = iteration;
        }
    }

    times (&tmsbuf2);
    printf("%ld\n",tmsbuf2.tms_utime - tmsbuf1.tms_utime
              + tmsbuf2.tms_stime - tmsbuf1.tms_stime);

    delta = clock () - delta;
    printf("%f sec\n",(float) delta / CLOCKS_PER_SEC);

}

int main (int argc, char *argv[])
{

    if (argc != 2)
    {
        printf("Hasznalat: ./mandelpng fajlnev\n");
        return -1;
    }
    FILE *fp = fopen(argv[1], "wb");
        if(!fp) return -1;
    
    png_structp png_ptr = png_create_write_struct(PNG_LIBPNG_VER_STRING,NULL,NULL,NULL);
    
    if(!png_ptr)
        return -1;
    png_infop info_ptr = png_create_info_struct(png_ptr);
    if(!info_ptr)
    {
        png_destroy_write_struct(&png_ptr,(png_infopp)NULL);
        return -1;
    }
   if (setjmp(png_jmpbuf(png_ptr)))
    {
        png_destroy_write_struct(&png_ptr, &info_ptr);
        fclose(fp);
        return -1;
    }
    png_init_io(png_ptr, fp);

   
    png_set_IHDR(png_ptr, info_ptr, SIZE, SIZE,
            8, PNG_COLOR_TYPE_RGB, PNG_INTERLACE_NONE,
            PNG_COMPRESSION_TYPE_BASE, PNG_FILTER_TYPE_BASE);

  
    
    png_text title_text;
    title_text.compression = PNG_TEXT_COMPRESSION_NONE;
    title_text.key = "Title";
    title_text.text = "Mandelbrot halmaz";
    png_set_text(png_ptr, info_ptr, &title_text, 1);
    

    png_write_info(png_ptr, info_ptr);
   
    png_bytep row = (png_bytep) malloc(3 * SIZE * sizeof(png_byte));
    
    
    int buffer[SIZE][SIZE];

    mandel(buffer);

    for (int j = 0; j < SIZE; ++j)
    {
        for (int k = 0; k < SIZE; ++k)
        {
            row[k*3] = (255 - (255 * buffer[j][k]) / ITERATION_LIMIT);
            row[k*3+1] = (255 - (255 * buffer[j][k]) / ITERATION_LIMIT);
            row[k*3+2] = (255 - (255 * buffer[j][k]) / ITERATION_LIMIT);
            row[k*3+3] = (255 - (255 * buffer[j][k]) / ITERATION_LIMIT);
        }
        png_write_row(png_ptr, row);
    }
    png_write_end(png_ptr, NULL);

    printf("%s mentve\n",argv[1]);

}
