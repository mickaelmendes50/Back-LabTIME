-- CreateTable
CREATE TABLE "User" (
    "codigo" INTEGER NOT NULL,
    "nomeCompleto" TEXT NOT NULL,
    "nomeSocial" TEXT NOT NULL,
    "dataDeNascimento" TEXT NOT NULL,
    "sexo" TEXT NOT NULL,
    "email" TEXT NOT NULL,
    "estado" TEXT NOT NULL,
    "municipio" TEXT NOT NULL,
    "numeroDeAcessos" INTEGER NOT NULL,
    "situacao" TEXT NOT NULL,
    "dataDeVinculo" TEXT NOT NULL,

    CONSTRAINT "User_pkey" PRIMARY KEY ("codigo")
);

-- CreateIndex
CREATE UNIQUE INDEX "User_email_key" ON "User"("email");
