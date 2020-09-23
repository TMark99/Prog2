library(neuralnet)

        a1 <- c(0,1,0,1) 
        a2 <- c(0,0,1,1) 
        OR <- c(0,1,1,1)
        AND <- c(0,0,0,1)

        orAnd.data <- data.frame(a1, a2, OR, AND)

        nn.orAnd <- neuralnet(OR+AND~a1+a2, orAnd.data, hidden=0, linear.output=FALSE, 
                            stepmax = 1e+07, threshold = 0.000001)

        plot(nn.orAnd)
            compute(nn.orAnd, orAnd.data[,1:2])
